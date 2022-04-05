package main.game.interfaces;

import main.game.models.Game;

import java.util.List;

public interface IGame {

    void play(Game game);

    Game extractGameObjectsFromGameData(List<String[]> gameData);
}
