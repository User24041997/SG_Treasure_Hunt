package main.game.models;

import java.awt.*;

/**
 * Mountain is an impassible obstacle for the adventurers
 */
public class Mountain extends Point {

    public Mountain(Integer xPos, Integer yPos) {
        super(xPos, yPos);
    }

    @Override
    public String toString() {
        return "     M     ";
    }
}
