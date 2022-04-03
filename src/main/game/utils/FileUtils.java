package main.game.utils;

import main.Main;
import main.game.enums.Message;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public static List<String> getListStringFromFile(String fileName) throws Exception {
        try {
            File file = new File(Main.class.getClassLoader().getResource(fileName).getFile());
            Stream<String> lines = Files.lines(file.toPath());
            List<String> returnLines = lines.collect(Collectors.toList());
            lines.close();
            return returnLines;
        } catch (IOException e) {
            throw new Exception(Message.FILE_LOADING_ERROR.toString());
        } catch (NullPointerException e) {
            throw new Exception(Message.FILE_NOT_FOUND.toString());
        }
    }
}
