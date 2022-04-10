package main.game.utils;

import main.Main;
import main.game.enums.Message;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    /**
     * Get the list of game data objects from an input file
     * @param fileName
     * @return returnList
     * @throws Exception
     */
    public static List<String[]> getListStringFromFile(String fileName) throws Exception {
        try {
            File file = new File(Main.class.getClassLoader().getResource(fileName).getFile());
            Stream<String> streamLines = Files.lines(file.toPath());
            List<String> stringLines = streamLines.collect(Collectors.toList());
            streamLines.close();
            List<String[]> returnList = new ArrayList<>();
            for (String line : stringLines) {
                if (line.charAt(0) != '#') {
                    String[] s = line.split(" - ");
                    returnList.add(s);
                }
            }
            return returnList;
        } catch (IOException e) {
            throw new Exception(Message.FILE_LOADING_ERROR.toString());
        } catch (NullPointerException e) {
            throw new Exception(Message.FILE_NOT_FOUND.toString());
        }
    }

    /**
     * Write the game played information to an output file
     * @param string
     * @param fileOutputName
     * @throws Exception
     */
    public static void writeGameOutputToFile(String string, String fileOutputName) throws Exception {
        try {
            PrintWriter writer = new PrintWriter(fileOutputName, StandardCharsets.UTF_8);
            writer.print(string);
            writer.close();
        } catch (IOException e) {
            throw new Exception(Message.FILE_LOADING_ERROR.toString());
        } catch (NullPointerException e) {
            throw new Exception(Message.FILE_NOT_FOUND.toString());
        }
    }
}
