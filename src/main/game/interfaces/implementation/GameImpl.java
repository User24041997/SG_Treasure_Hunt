package main.game.interfaces.implementation;

import main.game.enums.GameCharacter;
import main.game.enums.Message;
import main.game.interfaces.IGame;
import main.game.models.*;
import main.game.utils.CheckUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Game Implementation
 */
public class GameImpl implements IGame {

    /**
     * Simulate the movements of the adventurers and their interactions, rules are :
     * An adventurer cannot cross a mountain
     * An adventurer gains a treasure when he crosses one
     * First adventurers in the map has priority over another one when moving
     * @param game
     */
    @Override
    public void play(Game game) {

        GameMap gameMap = game.getGameMap();

        for (int i = 0; i < game.getTurnNumber(); i++) {
            System.out.println("TURN : " + i);
            for (Adventurer adventurer : game.getAdventurerList()) {
                // IF adventurer still has movements
                if (adventurer.hasMovements() && i < adventurer.getNumberOfMovements()) {
                    System.out.println("Movements " + adventurer.getName() + " : " + adventurer.getOrientation() + adventurer.getMovements().charAt(i));
                    System.out.println(game.refreshGameMap2DArray());
                    game.refreshGameMap2DArray();
                    // IF adventurer is still inside axis y
                    if (adventurer.isInsideMapHeightBorders(game.getGameMap().getHeight() - 1)) {
                        // GOING DOWN CONDITIONS
                        if (adventurer.isGoingDown(i) && adventurer.canMoveDown(gameMap.getHeight()) && gameMap.positionIsNotAnObstacle(adventurer.getXPos(), adventurer.getYPos() + 1)) {
                            adventurer.move(adventurer.getXPos(), adventurer.getYPos() + 1);
                            game.checkIfTreasureFound(adventurer);
                            continue;
                        }

                        // GOING UP CONDITIONS
                        if (adventurer.isGoingUp(i) && adventurer.canMoveUp(0) && gameMap.positionIsNotAnObstacle(adventurer.getXPos(), adventurer.getYPos() - 1)) {
                            adventurer.move(adventurer.getXPos(), adventurer.getYPos() - 1);
                            game.checkIfTreasureFound(adventurer);
                            continue;
                        }
                    }

                    // IF adventurer is still inside axis x
                    if (adventurer.isInsideMapWidthBorders(game.getGameMap().getWidth() - 1)) {
                        // GOING LEFT CONDITIONS
                        if (adventurer.isGoingLeft(i) && adventurer.canMoveLeft(0) && gameMap.positionIsNotAnObstacle(adventurer.getXPos() - 1, adventurer.getYPos())) {
                            adventurer.move(adventurer.getXPos() - 1, adventurer.getYPos());
                            game.checkIfTreasureFound(adventurer);
                            continue;
                        }

                        // GOING RIGHT CONDITIONS
                        if (adventurer.isGoingRight(i) && adventurer.canMoveRight(gameMap.getWidth()) && gameMap.positionIsNotAnObstacle(adventurer.getXPos() + 1, adventurer.getYPos())) {
                            adventurer.move(adventurer.getXPos() + 1, adventurer.getYPos());
                            game.checkIfTreasureFound(adventurer);
                            continue;
                        }
                    }
                }
            }
        }
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

        for (String[] objectData : gameData) {
            if (CheckUtils.isValidGameCharacter(objectData[0])) {
               if (objectData[0].equals(GameCharacter.GAME_MAP.toString()) && objectData.length == GameCharacter.GAME_MAP.getNumberOfElements()) {
                   gameMap = new GameMap(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]));
               } else if (objectData[0].equals(GameCharacter.MOUNTAIN.toString()) && objectData.length == GameCharacter.MOUNTAIN.getNumberOfElements()) {
                   Mountain mountain = new Mountain(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]));
                   mountainList.add(mountain);
               } else if (objectData[0].equals(GameCharacter.TREASURE.toString()) && objectData.length == GameCharacter.TREASURE.getNumberOfElements()) {
                   Treasure treasure = new Treasure(Integer.parseInt(objectData[1]), Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]));
                   treasureList.add(treasure);
               } else if (objectData[0].equals(GameCharacter.ADVENTURER.toString()) && objectData.length == GameCharacter.ADVENTURER.getNumberOfElements()) {
                   Adventurer adventurer = new Adventurer(objectData[1], Integer.parseInt(objectData[2]), Integer.parseInt(objectData[3]), objectData[4], objectData[5]);
                   adventurerList.add(adventurer);
               }
            }
        }

        // Initialize the turn numbers of the game
        Integer turnNumber = 0;
        if (!adventurerList.isEmpty()) {
            turnNumber = adventurerList.stream()
                    .max(Comparator.comparingInt(Adventurer::getNumberOfMovements))
                    .get().getNumberOfMovements();
        }

        if (gameMap.getGameMap2DArray() == null) {
            System.out.println(Message.GAME_MAP_NOT_INSTANCED);
            return null;
        } else {
            Game game = new Game(gameMap, mountainList, treasureList, adventurerList, turnNumber);
            return game;
        }
    }

}
