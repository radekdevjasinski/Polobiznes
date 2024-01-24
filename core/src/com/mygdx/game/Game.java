package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerList = new ArrayList<>();
    int turnOf;
    GameState gameState;
    boolean gameOver = false;
    CircleSquareDrawer circleSquareDrawer;

    public Game(CircleSquareDrawer circleSquareDrawer)
    {
        this.circleSquareDrawer = circleSquareDrawer;
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
            switch (gameState)
            {
                case START:
                    diceControl.rollingSetup();
                    gameState = GameState.DICE;
                    break;
                case DICE:
                    int value = diceControl.value();
                    if (value != -1)
                    {
                        movePlayer(playerList.get(turnOf), playerList.get(turnOf).currentCircleId +
                                diceControl.value());
                        gameState = GameState.BUYING;
                    }
                    break;
                case BUYING:
                    break;
                case FREE:
                    break;
            }
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
        Player.movePlayerToAdjacentCircle(player, id, circleSquareDrawer);
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
            case BUYING:
                return name + " decyduje o kupnie...";
            case FREE:
                return name + " kończy turę...";
            default:
                return "";
        }
    }
}
