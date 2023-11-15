package com.mygdx.game;

import java.util.HashMap;

public class Game {
    HashMap<Integer, Players> playerMap = new HashMap<Integer, Players>();

    public void addPlayer(int id, Players Player){
        playerMap.put(id, Player);
    }
    public Players getPlayer(int id){
        return playerMap.get(id);
    }
    public void setPlayers(){
        Players p1 = new Players("Kuba",5000, "D:/Polobiznesrel/assets/pawn1.png");
        Players p2 = new Players("Radek", 4999, "D:/Polobiznesrel/assets/pawn2.png");
        Players p3 = new Players("Eliza", 4998, "D:/Polobiznesrel/assets/pawn3.png");
        addPlayer(0,p1);
        addPlayer(1,p2);
        addPlayer(3,p3);
    }
}
