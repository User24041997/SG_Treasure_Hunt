package main.game.models;

import main.game.enums.GameCharacter;

/**
 * Game map
 */
public class GameMap {

    private Integer width;
    private Integer height;
    private String[][] gameMap;

    public GameMap() {
        this.width = 0;
        this.height = 0;
        gameMap = null;
    }

    public GameMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        gameMap = new String[width][height];
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String[][] getGameMap2DArray() {
        return gameMap;
    }

    public void setGameMap(String[][] gameMap) {
        this.gameMap = gameMap;
    }

    public Boolean positionIsNotAnObstacle(Integer xPos, Integer yPos) {
        return gameMap[xPos][yPos] == null ||
                (!gameMap[xPos][yPos].trim().equals(GameCharacter.MOUNTAIN.toString())
                        && !String.valueOf(gameMap[xPos][yPos].trim().charAt(0)).equals(GameCharacter.ADVENTURER.toString()));
    }

    public Boolean positionIsATreasure(Integer xPos, Integer yPos) {
        return gameMap[xPos][yPos] != null && !gameMap[xPos][yPos].trim().equals(GameCharacter.TREASURE.toString());
    }

    public String toMapString() {
        String res = "";
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.gameMap[j][i] != null) {
                    res += this.gameMap[j][i];
                } else {
                    res += "     -     ";
                }
            }
            res += "\r\n";
        }
        return res;
    }

    @Override
    public String toString() {
        return "C - " + width + " - " + height;
    }
}
