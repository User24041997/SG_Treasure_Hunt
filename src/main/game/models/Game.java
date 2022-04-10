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
    private Integer turnNumber;

    public Game(GameMap gameMap, List<Mountain> mountainList, List<Treasure> treasureList, List<Adventurer> adventurerList, Integer turnNumber) {
        this.gameMap = gameMap;
        this.mountainList = mountainList;
        this.treasureList = treasureList;
        this.adventurerList = adventurerList;
        this.turnNumber = turnNumber;
        this.refreshGameMap2DArray();
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

    public void checkIfTreasureFound(Adventurer adventurer) {
        if (gameMap.positionIsATreasure(adventurer.getXPos(), adventurer.getYPos())) {
            Treasure foundTreasure = treasureList.stream()
                    .filter(t -> t.getX() == adventurer.getXPos() && t.getY() == adventurer.getYPos())
                    .findFirst()
                    .orElse(null);
            if (foundTreasure != null && foundTreasure.canBeCollected()) {
                adventurer.collectTreasure();
                foundTreasure.isCollected();
            }
        }
    }

    public String refreshGameMap2DArray() {
        String[][] map = new String[gameMap.getWidth()][gameMap.getHeight()];

        if (mountainList != null && !mountainList.isEmpty()) {
            for (Mountain mountain : mountainList) {
                map[(int)mountain.getX()][(int)mountain.getY()] = mountain.toMapString();
            }
        }
        if (treasureList != null && !treasureList.isEmpty()) {
            for (Treasure treasure : treasureList) {
                map[(int)treasure.getX()][(int)treasure.getY()] = treasure.toMapString();
            }
        }
        if (adventurerList != null && !adventurerList.isEmpty()) {
            for (Adventurer adventurer : adventurerList) {
                map[(int)adventurer.getX()][(int)adventurer.getY()] = adventurer.toMapString();
            }
        }

        gameMap.setGameMap(map);

        return gameMap.toMapString();
    }

    @Override
    public String toString() {
        String res = "";
        res += this.gameMap + "\r\n";
        for (Mountain mountain : this.mountainList) {
            res += mountain.toString() + "\r\n";
        }
        for (Treasure treasure : this.treasureList) {
            if (!treasure.isEmpty()) {
                res += treasure.toString() + "\r\n";
            }
        }
        for (Adventurer adventurer : this.adventurerList) {
            res += adventurer.toString() + "\r\n";
        }
        return res;
    }


}
