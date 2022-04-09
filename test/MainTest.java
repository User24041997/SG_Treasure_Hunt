import main.game.interfaces.IGame;
import main.game.interfaces.implementation.GameImpl;
import main.game.models.*;
import main.game.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        gameMock.add("A - Andy - 2 - 2 - S - AADADAGGAAAA");
        List<String[]> gameData = FileUtils.getListStringFromFile("game_test.txt");
        List<String> gameDataToCompare = new ArrayList<>();
        for(String[] stringArray : gameData) {
            gameDataToCompare.add(String.join(" - ", stringArray));
        }
        assertArrayEquals(gameMock.toArray(new String[0]), gameDataToCompare.toArray(new String[0]));
    }

    @Test
    public void testExtractGameObjectsFromGameData() throws Exception {
        Game gameMock = this.createGameMock();

        IGame iGame = new GameImpl();

        List<String[]> gameData = FileUtils.getListStringFromFile("game_test.txt");
        Game gameToCompare = iGame.extractGameObjectsFromGameData(gameData);

        assertEquals(gameMock.getAdventurerList(), gameToCompare.getAdventurerList());
        assertEquals(gameMock.getMountainList(), gameToCompare.getMountainList());
        assertEquals(gameMock.getTreasureList(), gameToCompare.getTreasureList());
        //assertEquals(gameMock.getGameMap(), gameToCompare.getGameMap()); Must delete blank spaces

        assertEquals(gameMock.getTurnNumber(), gameToCompare.getTurnNumber());

    }

    @Test
    public void testWriteGameOutputToFile() throws Exception {
        Game gameMock = this.createGameMock();

        FileUtils.writeGameOutputToFile(gameMock.toString(), "test/output/game_mock_output.txt");

        byte[] file1Bytes = Files.readAllBytes(Paths.get("test/output/game_mock_output.txt"));
        byte[] file2Bytes = Files.readAllBytes(Paths.get("test/output/game_output_to_compare.txt"));

        String file1 = new String(file1Bytes, StandardCharsets.UTF_8);
        String file2 = new String(file2Bytes, StandardCharsets.UTF_8);

        assertEquals(file1.trim(), file2.trim());


    }

    private Game createGameMock() {
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
        adventurerListMock.add(new Adventurer("Andy", 2, 2, "S", "AADADAGGAAAA"));
        List<Mountain> mountainListMock = new ArrayList<>();
        mountainListMock.add(new Mountain(1, 0));
        mountainListMock.add(new Mountain(2, 1));
        List<Treasure> treasureListMock = new ArrayList<>();
        treasureListMock.add(new Treasure(0, 3, 2));
        treasureListMock.add(new Treasure(1, 3, 2));

       return new Game(gameMapMock, mountainListMock, treasureListMock, adventurerListMock);
    }
}
