package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInputOutput {

    public static String getText(Path path) throws IOException {
        try {
            if (!(Files.size(path) == 0)) {
                return Files.readString(path);
            } else {
                System.out.println("File is empty. Input text in your file and return");
                System.exit(0);
            }

        } catch (IOException e) {
            System.out.println("Problem with file");
                   }
        return null;
    }

    public static void sendTextResult (String textResult) throws IOException {
        String fileOutputName = "output.txt";
        if (Files.notExists(Path.of(fileOutputName))) {
            Files.createFile(Path.of(fileOutputName));
        }
        try {

            Files.writeString(Path.of(fileOutputName), textResult);
        }
        catch (IOException e) {
            System.err.println("Error file writing");
        }

    }
}

