package main;

import main.game.interfaces.IGame;
import main.game.interfaces.implementation.GameImpl;
import main.game.models.*;
import main.game.utils.FileUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            IGame iGame = new GameImpl();

            List<String[]> gameData = FileUtils.getListStringFromFile("game.txt");

            Game game = iGame.extractGameObjectsFromGameData(gameData);

            System.out.println("GAME STARTED");
            System.out.println("============");
            System.out.println(game.initializeGameMap2DArray());
            System.out.println(game);

            iGame.play(game);

            System.out.println("GAME PLAYED");
            System.out.println("============");
            System.out.println(game.initializeGameMap2DArray());
            System.out.println(game);


            FileUtils.writeGameOutputToFile(game.toString(), "game_output/game_output.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
