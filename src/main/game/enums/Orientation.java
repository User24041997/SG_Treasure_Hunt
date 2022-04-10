package main.game.enums;

/**
 * Orientation of the adventurers
 */
public enum Orientation {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("O");

    private final String value;

    Orientation(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
