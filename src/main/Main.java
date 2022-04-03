package main;

import main.game.utils.FileUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<String> gameData = FileUtils.getListStringFromFile("game.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
