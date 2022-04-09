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

            iGame.play(game);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
