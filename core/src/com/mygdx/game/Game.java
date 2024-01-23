package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerList = new ArrayList<>();
    int turnOf;
    GameState gameState;

    public Game()
    {
        playerList.add(new Player(0, 5000, "Radek"));
        playerList.add(new Player(1, 5000, "Kuba"));
        playerList.add(new Player(2, 5000, "Eliza"));
        playerList.add(new Player(3, 5000, "Jasam"));
        turnOf = 0;
        gameState = GameState.DICE;

    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    public String gameMessage()
    {
        String name = "Gracz " + (turnOf+1);
        switch (gameState){

            case DICE:
                return name + " rzuca kostką...";
            case BUYING:
                return name + " decyduje o kupnie...";
            case FREE:
                return name + " kończy turę...";
            default:
                return "";
        }
    }
}
