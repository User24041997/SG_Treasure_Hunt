package main.game.models;

import main.game.enums.Movement;
import main.game.enums.Orientation;

import java.awt.*;

public class Adventurer extends Point {

    private String name;
    private String orientation;
    private String movements;
    private Integer treasureCount;


    public Adventurer(String name, Integer xPos, Integer yPos, String orientation, String movements) {
        super(xPos, yPos);
        this.name = name;
        this.orientation = orientation;
        this.movements = movements;
        this.treasureCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
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

    public Integer getXPos() {
        return x;
    }

    public Integer getYPos() {
        return y;
    }

    public Integer getNumberOfMovements() {
        return movements.length();
    }

    public Boolean canMoveDown(Integer downLimit) {
        return y + 1 < downLimit;
    }

    public Boolean canMoveUp(Integer upLimit) {
        return y - 1 >= upLimit;
    }

    public Boolean canMoveLeft(Integer leftLimit) {
        return x - 1 >= leftLimit;
    }

    public Boolean canMoveRight(Integer rightLimit) {
        return x + 1 < rightLimit;
    }

    public Boolean isGoingDown(Integer index) {
        if ((orientation.equals(Orientation.SOUTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_FORWARD.toString()))
                || (orientation.equals(Orientation.EAST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_RIGHT.toString()))
                || (orientation.equals(Orientation.WEST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_LEFT.toString()))) {
            orientation = Orientation.SOUTH.toString();
            return true;
        } else {
            return false;
        }
    }

    public Boolean isGoingUp(Integer index) {
        if ((orientation.equals(Orientation.NORTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_FORWARD.toString()))
                || (orientation.equals(Orientation.EAST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_LEFT.toString()))
                || (orientation.equals(Orientation.WEST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_RIGHT.toString()))) {
            orientation = Orientation.NORTH.toString();
            return true;
        } else {
            return false;
        }
    }

    public Boolean isGoingLeft(Integer index) {
        if ((orientation.equals(Orientation.WEST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_FORWARD.toString()))
                || (orientation.equals(Orientation.NORTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_LEFT.toString()))
                || (orientation.equals(Orientation.SOUTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_RIGHT.toString()))) {
            orientation = Orientation.WEST.toString();
            return true;
        } else {
            return false;
        }
    }

    public Boolean isGoingRight(Integer index) {
        if ((orientation.equals(Orientation.EAST.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_FORWARD.toString()))
                || (orientation.equals(Orientation.NORTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_RIGHT.toString()))
                || (orientation.equals(Orientation.SOUTH.toString()) && String.valueOf(movements.charAt(index)).equals(Movement.MOVE_LEFT.toString()))) {
            orientation = Orientation.EAST.toString();
            return true;
        } else {
            return false;
        }
    }

    public Boolean isInsideMapHeightBorders(Integer heightLimit) {
        return y >= 0 && y <= heightLimit;
    }

    public Boolean isInsideMapWidthBorders(Integer widthLimit) {
        return x >= 0 && x <= widthLimit;
    }

    public void collectTreasure() {
        treasureCount++;
    }

    public String toMapString() {
        return "    A(" + name + ")";
    }

    @Override
    public String toString() {
        return "A - " + name + " - " + x + " - " + y + " - " + orientation + " - " + treasureCount;
    }
}
