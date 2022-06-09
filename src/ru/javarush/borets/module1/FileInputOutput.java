package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputOutput {
    public static final String OUTPUT_TXT = "output.txt";
    public static final String INPUT_TXT = "input.txt";

    public static String readTextFromFile(Path path)  {
        try {
            if (!(Files.size(path) == 0)) {
                return Files.readString(path);
            } else {
                System.out.println("File is empty. Input text in your file and return");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "Problem with file";
    }

    public static void sendTextResult(String textResult) throws IOException {
        String fileOutputName = OUTPUT_TXT;
        if (Files.notExists(Path.of(fileOutputName))) {
            Files.createFile(Path.of(fileOutputName));
        }
        try {
            Files.writeString(Path.of(fileOutputName), textResult);
        } catch (IOException e) {
            System.err.println("Error file writing" + e.getMessage());
        }
    }
}

