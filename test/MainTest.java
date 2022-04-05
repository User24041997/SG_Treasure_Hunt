import main.game.interfaces.IGame;
import main.game.interfaces.implementation.GameImpl;
import main.game.models.*;
import main.game.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testReadFile() throws Exception {
        List<String> gameMock = new ArrayList<>();
        gameMock.add("C - 3 - 4");
        gameMock.add("M - 1 - 0");
        gameMock.add("M - 2 - 1");
        gameMock.add("T - 0 - 3 - 2");
        gameMock.add("T - 1 - 3 - 2");
        gameMock.add("A - Lara - 1 - 1 - S - AADADAGGA");
        List<String[]> gameData = FileUtils.getListStringFromFile("game_test.txt");
        List<String> gameDataToCompare = new ArrayList<>();
        for(String[] stringArray : gameData) {
            gameDataToCompare.add(String.join(" - ", stringArray));
        }
        assertArrayEquals(gameMock.toArray(new String[0]), gameDataToCompare.toArray(new String[0]));
    }

    @Test
    public void testExtractGameObjectsFromGameData() throws Exception {
        String[][] gameMapArrayMock = new String[][] {
                {"-", "M", "-"},
                {"-", "A(Lara)", "M"},
                {"-", "-", "-"},
                {"-", "-", "-"},
                {"T(2)", "T(3)", "-"}
        };

        GameMap gameMapMock = new GameMap(3, 4);
        gameMapMock.setGameMap(gameMapArrayMock);
        List<Adventurer> adventurerListMock = new ArrayList<>();
        adventurerListMock.add(new Adventurer("Lara", 1, 1, "S", "AADADAGGA"));
        List<Mountain> mountainListMock = new ArrayList<>();
        mountainListMock.add(new Mountain(1, 0));
        mountainListMock.add(new Mountain(2, 1));
        List<Treasure> treasureListMock = new ArrayList<>();
        treasureListMock.add(new Treasure(0, 3, 2));
        treasureListMock.add(new Treasure(1, 3, 2));

        Game gameMock = new Game(gameMapMock, mountainListMock, treasureListMock, adventurerListMock);

        IGame iGame = new GameImpl();

        List<String[]> gameData = FileUtils.getListStringFromFile("game_test.txt");
        Game gameToCompare = iGame.extractGameObjectsFromGameData(gameData);

        assertEquals(gameMock.getAdventurerList(), gameToCompare.getAdventurerList());
        assertEquals(gameMock.getMountainList(), gameToCompare.getMountainList());
        assertEquals(gameMock.getTreasureList(), gameToCompare.getTreasureList());
        //assertEquals(gameMock.getGameMap(), gameToCompare.getGameMap()); Must delete blank spaces

    }
}
