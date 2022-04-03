package main.game.models;

import java.util.List;

/**
 * Game object
 */
public class Game {
    private Map map;
    private List<Mountain> mountainList;
    private List<Treasure> treasureList;
    private List<Adventurer> adventurerList;

    public Game(Map map, List<Mountain> mountainList, List<Treasure> treasureList, List<Adventurer> adventurerList) {
        this.map = map;
        this.mountainList = mountainList;
        this.treasureList = treasureList;
        this.adventurerList = adventurerList;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
