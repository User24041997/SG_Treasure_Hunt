package main.game.models;

import java.awt.*;

/**
 * Mountain is an impassible obstacle for the adventurers
 */
public class Mountain extends Point {

    public Mountain(Integer xPos, Integer yPos) {
        super(xPos, yPos);
    }

    public String toMapString() {
        return "     M     ";
    }

    @Override
    public String toString() {
        return "M - " + x + " - " + y;
    }
}
