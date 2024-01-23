package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca logikę gry.
 */
public class Game {
    List<Player> playerList = new ArrayList<>();
    int turnOf;

    public Game()
    {
        playerList.add(new Player(0, 5000, "Radek"));
        playerList.add(new Player(1, 5000, "Kuba"));
        playerList.add(new Player(2, 5000, "Eliza"));
        playerList.add(new Player(3, 5000, "Jasam"));
        turnOf = 0;

    }
    public List<Player> getPlayerList() {
        return playerList;
    }
}
