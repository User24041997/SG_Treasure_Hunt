package main.game.utils;

import main.game.enums.Message;

public class CheckUtils {

    /**
     * Verify if the letter in text file is a valid game letter
     * @param s
     * @return bool
     */
    public static Boolean isValidGameCharacter(String s) {
        Boolean bool = false;
        switch(s) {
            case "A":
                bool = true;
                break;
            case "C":
                bool = true;
                break;
            case "M":
                bool = true;
                break;
            case "T":
                bool = true;
                break;
            default:
                System.out.println(Message.INVALID_CHAR_INPUT);
                break;
        }
        return bool;
    }
}
