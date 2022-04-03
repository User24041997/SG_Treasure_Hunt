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
        List<String> gameData = FileUtils.getListStringFromFile("game_test.txt");
        assertArrayEquals(gameMock.toArray(new String[0]), gameData.toArray(new String[0]));
    }
}
