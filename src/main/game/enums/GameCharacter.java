package main.game.enums;

/**
 * Possible game characters read from file input
 * First value is the character expected
 * Second value is the number of elements expected
 */
public enum GameCharacter {
    ADVENTURER("A", 6),
    MOUNTAIN("M", 3),
    GAME_MAP("C", 3),
    TREASURE("T", 4);

    private final String value;
    private final Integer numberOfElements;

    GameCharacter(final String value, Integer numberOfElements) {
        this.value = value;
        this.numberOfElements = numberOfElements;
    }

    public Integer getNumberOfElements() {
        return this.numberOfElements;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
