package main.game.models;

import main.game.enums.Direction;

import java.awt.*;

public class Adventurer extends Point {

    private String name;
    private String direction;
    private String movements;


    public Adventurer(String name, Integer xPos, Integer yPos, String direction, String movements) {
        super(xPos, yPos);
        this.name = name;
        this.direction = direction;
        this.movements = movements;
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

    @Override
    public String toString() {
        return "    A(" + name + ")";
    }
}
