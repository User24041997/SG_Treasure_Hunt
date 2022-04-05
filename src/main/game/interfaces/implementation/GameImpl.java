package main.game.interfaces.implementation;

import main.game.enums.Message;
import main.game.interfaces.IGame;
import main.game.models.*;
import main.game.utils.CheckUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Implementation
 */
public class GameImpl implements IGame {

    /**
     * Simulate the movements of the adventurers and their interactions
     * @param game
     */
    @Override
    public void play(Game game) {

    }

    /**
     * Extract the game objects from the game data parameter
     * @param gameData
     * @return Game
     */
    @Override
    public Game extractGameObjectsFromGameData(List<String[]> gameData) {
        GameMap gameMap = new GameMap();
        List<Adventurer> adventurerList = new ArrayList<>();
        List<Mountain> mountainList = new ArrayList<>();
        List<Treasure> treasureList = new ArrayList<>();

        // TODO Check if other parameters are valid
        for (String[] objectData : gameData) {
            if (CheckUtils.isValidGameCharacter(objectData[0])) {
                switch(objectData[0]) {
                    case "A":
                        Adventurer adventurer = new Adventurer(objectData[1], Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]), objectData[4], objectData[5]);
                        adventurerList.add(adventurer);
                        break;
                    case "C":
                        gameMap = new GameMap(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]));
                        break;
                    case "M":
                        Mountain mountain = new Mountain(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]));
                        mountainList.add(mountain);
                        break;
                    case "T":
                        Treasure treasure = new Treasure(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]));
                        treasureList.add(treasure);
                        break;
                    default:
                        break;
                }
            }
        }

        gameMap.setGameMap(initializeGameMapWithGameObjects(gameMap.getWidth(), gameMap.getHeight(), mountainList, treasureList, adventurerList));

        if (gameMap.getGameMap() == null) {
            System.out.println(Message.GAME_MAP_NOT_INSTANCED);
            return null;
        } else {
            return new Game(gameMap, mountainList, treasureList, adventurerList);
        }
    }

    /**
     * Initialize the game map with objects
     * @return
     */
    private String[][] initializeGameMapWithGameObjects(Integer width, Integer height, List<Mountain> mountainList, List<Treasure> treasureList, List<Adventurer> adventurerList) {
        String[][] gameMap = new String[height][width];

        if (mountainList != null && !mountainList.isEmpty()) {
            for (Mountain mountain : mountainList) {
                gameMap[(int)mountain.getY()][(int)mountain.getX()] = mountain.toString();
            }
        }
        if (treasureList != null && !treasureList.isEmpty()) {
            for (Treasure treasure : treasureList) {
                gameMap[(int)treasure.getY()][(int)treasure.getX()] = treasure.toString();
            }
        }
        if (adventurerList != null && !adventurerList.isEmpty()) {
            for (Adventurer adventurer : adventurerList) {
                gameMap[(int)adventurer.getY()][(int)adventurer.getX()] = adventurer.toString();
            }
        }
        return gameMap;
    }



}
