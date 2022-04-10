package main.game.enums;

/**
 * Possible movements for the adventurers
 */
public enum Movement {
    MOVE_FORWARD("A"),
    MOVE_LEFT("G"),
    MOVE_RIGHT("D");

    private final String value;

    Movement(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
