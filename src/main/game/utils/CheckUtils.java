package main.game.utils;

import main.game.enums.GameCharacter;

public class CheckUtils {

    /**
     * Verify if the letter in text file is a valid game letter
     * @param s
     * @return bool
     */
    public static Boolean isValidGameCharacter(String s) {
        return s.equals(GameCharacter.TREASURE.toString())
                || s.equals(GameCharacter.ADVENTURER.toString())
                || s.equals(GameCharacter.GAME_MAP.toString())
                || s.equals(GameCharacter.MOUNTAIN.toString());
    }
}
