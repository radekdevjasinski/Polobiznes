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
        if (!gameOver)
        {
            System.out.println(playerList.get(turnOf).name);
            for (Card cardOwn : playerList.get(turnOf).cards)
            {
                System.out.print(cardOwn.nameCity + " ");
            }
            switch (gameState)
            {
                case START:
                    diceControl.rollingSetup();
                    gameState = GameState.DICE;
                    break;
                case DICE:
                    movePlayer(playerList.get(turnOf), (playerList.get(turnOf).currentCircleId +
                            diceControl.value()) % 40);
                    gameState = GameState.MOVING;
                    break;
                case MOVING:


                    gameState = GameState.BUYING;
                    break;
                case BUYING:
                    Card card = CircleSquareDrawer.circleMap.get(playerList.get(turnOf).currentCircleId).getCityCard();
                    if (card != null)
                    {
                        if (isCardFree(card))
                        {
                            playerList.get(turnOf).changeMoney(card.costOfPurchase * (-1));
                            playerList.get(turnOf).cards.add(card);
                        }
                    }
                    else
                    {
                        chanceController.RandomizeChance();
                        chanceController.ExecuteChance(this);
                    }
                    gameState = GameState.FREE;
                    break;
                case FREE:
                    chanceController.randomChance = null;
                    nextTurn();
                    gameState = GameState.START;
                    break;
            }
        }
    }
    void nextTurn()
    {
        turnOf = (turnOf + 1) % 4;
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
    public boolean isCardFree(Card cardToCheck)
    {
        for (Player player : getPlayerList())
        {
            if (player.id != turnOf)
            {
                for (Card card : player.cards)
                {
                    if (Objects.equals(cardToCheck.getNameCity(), card.getNameCity()))
                    {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
