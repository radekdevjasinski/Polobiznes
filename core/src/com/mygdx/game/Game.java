package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    List<Player> playerList = new ArrayList<>();
    int turnOf;
    GameState gameState;
    boolean gameOver = false;
    CircleSquareDrawer circleSquareDrawer;
    ChanceController chanceController;

    public Game(CircleSquareDrawer circleSquareDrawer, ChanceController chanceController)
    {
        this.circleSquareDrawer = circleSquareDrawer;
        this.chanceController = chanceController;
        playerList.add(new Player(0, 5000, "Radek"));
        playerList.add(new Player(1, 5000, "Kuba"));
        playerList.add(new Player(2, 5000, "Eliza"));
        playerList.add(new Player(3, 5000, "Jasam"));
        turnOf = 0;
        gameState = GameState.START;

    }
    public void gameLoop(DiceControl diceControl)
    {
        if (!isGameOver())
        {
            switch (gameState)
            {
                case START:
                    if (playerList.get(turnOf).turnsInPrison == 0)
                    {
                        diceControl.rollingSetup();
                        gameState = GameState.DICE;
                    }
                    else
                    {
                        gameState = GameState.FREE;
                    }
                    break;
                case DICE:
                    int move = playerList.get(turnOf).currentCircleId +
                            diceControl.value();
                    if (move >= 40)
                        playerList.get(turnOf).changeMoney(200);
                    move = move % 40;
                    movePlayer(playerList.get(turnOf), move);
                    gameState = GameState.MOVING;
                    break;
                case MOVING:
                    gameState = GameState.BUYING;
                    break;
                case BUYING:

                    handleBuying();
                    gameState = GameState.FREE;
                    break;
                case FREE:
                    if (playerList.get(turnOf).turnsInPrison > 0)
                    {
                        playerList.get(turnOf).turnsInPrison--;
                    }
                    chanceController.randomChance = null;
                    nextTurn();
                    gameState = GameState.START;
                    break;
            }
        }
        else
        {
            System.out.println("GAME OVER");
        }
    }
    void nextTurn()
    {
        turnOf = (turnOf + 1) % 4;
    }
    void handleBuying()
    {
        Card card = CircleSquareDrawer.circleMap.get(playerList.get(turnOf).currentCircleId).getCityCard();
        Train train = CircleSquareDrawer.circleMap.get(playerList.get(turnOf).currentCircleId).getTrainCard();
        Shop shop = CircleSquareDrawer.circleMap.get(playerList.get(turnOf).currentCircleId).getShopCard();
        int[] chanceSpaces = {4, 17, 22, 33, 7, 28};
        int[] prisonSpaces = {30};
        int[] paySpaces = {2,38};
        if (card != null)
        {
            if (isCardFree(card.getNameCity()))
            {
                playerList.get(turnOf).changeMoney(card.costOfPurchase * (-1));
                playerList.get(turnOf).cards.add(card);
                card.owner = playerList.get(turnOf).name;
            }
            else if (playerList.get(turnOf).id != cardOwner(card.getNameCity()).id)
            {
                playerList.get(turnOf).changeMoney(card.parkingCost * (-1));
                cardOwner(card.getNameCity()).changeMoney(card.parkingCost);
            }
        }
        else if(train != null)
        {
            if (isCardFree(train.getNameTrain()))
            {
                playerList.get(turnOf).changeMoney(train.costOfPurchase * (-1));
                playerList.get(turnOf).trains.add(train);
                train.owner = playerList.get(turnOf).name;
            }
            else if (playerList.get(turnOf).id != cardOwner(train.getNameTrain()).id)
            {
                playerList.get(turnOf).changeMoney(train.earningOneStation* (-1));
                cardOwner(train.getNameTrain()).changeMoney(train.earningOneStation);
            }
        }
        else if(shop != null)
        {
            if (isCardFree(shop.shopName))
            {
                playerList.get(turnOf).changeMoney(shop.costOfPurchase * (-1));
                playerList.get(turnOf).shops.add(shop);
                shop.owner = playerList.get(turnOf).name;
            }
            else if (playerList.get(turnOf).id != cardOwner(shop.shopName).id)
            {
                playerList.get(turnOf).changeMoney(shop.earningFromAnotherPlayer* (-1));
                cardOwner(shop.shopName).changeMoney(shop.earningFromAnotherPlayer);
            }
        }
        else if (isOnThePlace(chanceSpaces))
        {
            chanceController.RandomizeChance();
            chanceController.ExecuteChance(this);
        }
        else if (isOnThePlace(prisonSpaces))
        {
            playerList.get(turnOf).turnsInPrison = 2;
            movePlayer(playerList.get(turnOf), 10);

        }
        else if (isOnThePlace(paySpaces))
        {
            playerList.get(turnOf).changeMoney(-200);
        }
    }

    public void inicialization()
    {
        for (Player player : playerList)
        {
            movePlayer(player, 0);
        }
    }
    public void movePlayer(Player player, int id)
    {
        Player.movePlayer(player, id, circleSquareDrawer);
        player.currentCircleId = id;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    public String gameMessage()
    {
        String name = "Gracz " + (turnOf+1);
        switch (gameState){

            case START:
                return name + " rzuca kostką...";
            case DICE:
                return name + " wykonuje ruch...";
            case MOVING:
                return name + " Ląduje na polu...";
            case BUYING:
                return name + " decyduje o kupnie...";
            case FREE:
                return name + " kończy turę...";
            default:
                return "";
        }
    }
    public boolean isCardFree(String cardName)
    {
        for (Player player : getPlayerList())
        {
            if (player.id != turnOf)
            {
                for (Card card : player.cards)
                {
                    if (Objects.equals(cardName, card.getNameCity()))
                        return false;
                }
                for (Train train : player.trains)
                {
                    if (Objects.equals(cardName, train.getNameTrain()))
                        return false;
                }
                for (Shop shop : player.shops)
                {
                    if (Objects.equals(cardName, shop.getShopName()))
                        return false;
                }

            }
        }
        return true;
    }
    public Player cardOwner(String cardName)
    {
        for (Player player : getPlayerList())
        {
            if (player.id != turnOf)
            {
                for (Card cards : player.cards)
                {
                    if (Objects.equals(cardName, cards.getNameCity()))
                    {
                        return player;
                    }
                }
                for (Train train : player.trains)
                {
                    if (Objects.equals(cardName, train.getNameTrain()))
                    {
                        return player;
                    }
                }
                for (Shop shop : player.shops)
                {
                    if (Objects.equals(cardName, shop.getShopName()))
                    {
                        return player;
                    }
                }

            }
        }
        return null;
    }
    public boolean isOnThePlace(int[] ids)
    {
        for (int i=0; i < ids.length; i++)
        {
            if (playerList.get(turnOf).currentCircleId == ids[i])
                return true;
        }
        return false;
    }
    public boolean isGameOver()
    {
        for (Player player : playerList)
        {
            if (player.cash <= 0)
            {
                return true;
            }
        }
        return false;
    }

}
