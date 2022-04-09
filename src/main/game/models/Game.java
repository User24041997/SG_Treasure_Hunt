package main.game.models;

import java.util.Comparator;
import java.util.List;

/**
 * Game object
 */
public class Game {
    private GameMap gameMap;
    private List<Mountain> mountainList;
    private List<Treasure> treasureList;
    private List<Adventurer> adventurerList;
    private Integer turnNumber;

    public Game(GameMap gameMap, List<Mountain> mountainList, List<Treasure> treasureList, List<Adventurer> adventurerList) {
        this.gameMap = gameMap;
        this.mountainList = mountainList;
        this.treasureList = treasureList;
        this.adventurerList = adventurerList;
        if (!adventurerList.isEmpty()) {
            turnNumber = adventurerList.stream()
                    .max(Comparator.comparingInt(Adventurer::getMovementsNumber))
                    .get().getMovementsNumber();
        } else {
            turnNumber = 0;
        }
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

    public Integer getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        String res = "";
        res += this.gameMap + "\r\n";
        for (Mountain mountain : this.mountainList) {
            res += mountain.toString() + "\r\n";
        }
        for (Treasure treasure : this.treasureList) {
            res += treasure.toString() + "\r\n";
        }
        for (Adventurer adventurer : this.adventurerList) {
            res += adventurer.toString() + "\r\n";
        }
        return res;
    }

}
