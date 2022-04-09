package main.game.models;

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
        gameMap = new String[height][width];
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

    public String[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(String[][] gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.gameMap[i][j] != null) {
                    res += this.gameMap[i][j];
                } else {
                    res += "     -     ";
                }
            }
            res += "\n";
        }
        return res;
    }
}
