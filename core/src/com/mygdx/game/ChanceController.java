package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChanceController {
    private  final String filePath = "D:\\PoloBiznesNew\\assets\\kartySzansy.txt"; //D:\PoloBiznesNew\assets\kartySzansy.txt
    public List<Chance> chances;
    public Chance randomChance = null;
    public ChanceController() throws IOException {
        readFile(filePath);
    }

    public List<Chance> readFile(String filePath) throws IOException {
        chances = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {

                Chance chance = new Chance(line, br.readLine());
                chances.add(chance);
            }
        }

        return chances;
    }
    public void RandomizeChance()
    {
        Random random = new Random();
        randomChance = chances.get(random.nextInt(chances.size()));
    }
    public void ExecuteChance(Game game)
    {
        char code = randomChance.getCode().charAt(0);
        switch (code)
        {
            case 't':
                String teleport = randomChance.getCode().substring(2);
                int teleportTo = Integer.parseInt(teleport);
                System.out.println(teleportTo);
                game.movePlayer(game.playerList.get(game.turnOf),teleportTo);
                break;
            case 'p':
                String amount = randomChance.getCode().substring(2);
                int amountOfMoney = Integer.parseInt(amount);
                System.out.println(amountOfMoney);
                game.playerList.get(game.turnOf).changeMoney(amountOfMoney);
                break;
            case 'a':
                game.playerList.get(game.turnOf).turnsInPrison = 2;
                game.movePlayer(game.playerList.get(game.turnOf), 10);
            default:
                break;
        }
    }
}
