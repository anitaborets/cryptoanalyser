package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public interface Validator {
    static String pathValidation() throws IOException {
        System.out.println("************************");
        System.out.println("Create a file.txt and input your text there.");
        System.out.println(" Enter your choice please:");
        System.out.println();
        System.out.println("1.You can input path");
        System.out.println("2.Please create file input.txt for me");
        System.out.println("3.You have text in file input.txt");

        int choice = Menu.keyboard.nextInt();

        if (choice == 1) {
            System.out.println("Enter the file path");
            Scanner console = new Scanner(System.in);
            String filePath = console.nextLine();
            Path path = Paths.get(filePath);

            if (Files.notExists(path)) {
                System.err.println("File not exists");
                Menu.showMenu();
            }

            if (!Files.isRegularFile(path)) {
                System.err.println("Create a file.txt and input your text there.");
                pathValidation();
            }

            if (!filePath.endsWith(".txt")) {
                System.err.println("File is not format .txt. Create a file format.txt and input your text there.");
                pathValidation();
            }

            if (Files.size(path) == 0) {
                System.out.println("File is empty. Input text in your file and return");
                System.exit(0);
            }
            return path.toString();

        } else if (choice == 2) {
            if (Files.notExists(Path.of("input.txt"))) {
                Files.createFile(Path.of("input.txt"));
            }
            System.out.println("File is created successfully.");
            System.out.println("************************");
            System.out.println("Please input your text to the file and return");
            System.exit(0);
            return null;

        } else if (choice == 3) {
            return "input.txt";

        } else {
            Menu.showMenu();
            return null;
        }
    }

    static int offsetValidation() {
        int offset = 0;
        System.out.println("Enter offset - the number from 1 to 33");

        try {
            offset = Menu.keyboard.nextInt();

            if (offset < 1 || offset > 33) {
                System.out.println("Enter offset - the number from 1 to 33");
            }
        } catch (NumberFormatException e) {
            System.out.println("It is not number");
            offsetValidation();
        }
        return offset;
    }
}
