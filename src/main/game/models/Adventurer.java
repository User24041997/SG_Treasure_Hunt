package main.game.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Adventurer extends Point {

    private String name;
    private String direction;
    private String movements;
    private Integer treasureCount;


    public Adventurer(String name, Integer xPos, Integer yPos, String direction, String movements) {
        super(xPos, yPos);
        this.name = name;
        this.direction = direction;
        this.movements = movements;
        this.treasureCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }

    public Integer getTreasureCount() {
        return treasureCount;
    }

    public void setTreasureCount(Integer treasureCount) {
        this.treasureCount = treasureCount;
    }

    public ArrayList<String> getListMovements() {
        return new ArrayList<>(Arrays.asList(movements.split("")));
    }

    public Integer getMovementsNumber() {
        return movements.length();
    }

    public String toMapString() {
        return "    A(" + name + ")";
    }

    @Override
    public String toString() {
        return "A - " + name + " - " + x + " - " + y + " - " + direction + " - " + treasureCount;
    }
}
