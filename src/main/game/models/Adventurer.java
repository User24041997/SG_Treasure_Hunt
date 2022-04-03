package main.game.models;

import main.game.enums.Direction;
import main.game.enums.Movement;

import java.awt.*;
import java.util.List;

public class Adventurer extends Point {

    private String name;
    private Direction direction;
    private List<Movement> movements;


    public Adventurer(Integer xPos, Integer yPos, String name, Direction direction, List<Movement> movements) {
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public String toString() {
        return "A";
    }
}
