package main.game.enums;

/**
 * Possible game characters read from file input
 */
public enum GameCharacter {
    ADVENTURER("A"),
    MOUNTAIN("M"),
    GAME_MAP("C"),
    TREASURE("T");

    private final String value;

    GameCharacter(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
