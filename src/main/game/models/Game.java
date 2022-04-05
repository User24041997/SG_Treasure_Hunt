package main.game.models;

import java.util.List;

/**
 * Game object
 */
public class Game {
    private GameMap gameMap;
    private List<Mountain> mountainList;
    private List<Treasure> treasureList;
    private List<Adventurer> adventurerList;

    public Game(GameMap gameMap, List<Mountain> mountainList, List<Treasure> treasureList, List<Adventurer> adventurerList) {
        this.gameMap = gameMap;
        this.mountainList = mountainList;
        this.treasureList = treasureList;
        this.adventurerList = adventurerList;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public List<Mountain> getMountainList() {
        return mountainList;
    }

    public void setMountainList(List<Mountain> mountainList) {
        this.mountainList = mountainList;
    }

    public List<Treasure> getTreasureList() {
        return treasureList;
    }

    public void setTreasureList(List<Treasure> treasureList) {
        this.treasureList = treasureList;
    }

    public List<Adventurer> getAdventurerList() {
        return adventurerList;
    }

    public void setAdventurerList(List<Adventurer> adventurerList) {
        this.adventurerList = adventurerList;
    }

}
