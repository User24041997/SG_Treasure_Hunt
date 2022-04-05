package main.game.enums;

public enum Message {
    FILE_NOT_FOUND("File not found"),
    FILE_LOADING_ERROR("Error during file loading"),
    INVALID_CHAR_INPUT("There is an invalid char in the game text input"),
    GAME_MAP_NOT_INSTANCED("The game map was not instanced");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
