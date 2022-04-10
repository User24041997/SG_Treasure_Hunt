package main.game.models;

import java.awt.*;

/**
 * Treasure is collectable by the adventurers
 */
public class Treasure extends Point {

    private Integer count;

    public Treasure(Integer xPos, Integer yPos, Integer count) {
        super(xPos, yPos);
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void isCollected() {
        count--;
    }

    public Boolean canBeCollected() {
        return count > 0;
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public String toMapString() {
        return "     T(" + count + ")  ";
    }

    @Override
    public String toString() {
        return "T - " + x + " - " + y + " - " + count;
    }
}
