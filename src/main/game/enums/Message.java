package main.game.enums;

public enum Message {
    FILE_NOT_FOUND("File not found"),
    FILE_LOADING_ERROR("Error during file loading");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
