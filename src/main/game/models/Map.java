package main.game.models;

/**
 * Game map
 */
public class Map {

    private Integer width;
    private Integer height;
    private String[][] map;

    public Map(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        map = new String[width][height];
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

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                res += "-";
            }
            res += "\n";
        }
        return res;
    }
}
