package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static ru.javarush.borets.module1.CryptographerRu.*;
import static ru.javarush.borets.module1.FileInputOutput.*;

public class Menu implements ValidatorWithDialog {
    public static Scanner keyboard = new Scanner(System.in);

    public static final String WRITE_RESULT_IN_FILE = "Thank you. Result will be write in" + OUTPUT_TXT;


    public static void showMenu() throws IOException {
        String text;
        int offset;

        System.out.println("************************");
        System.out.println(" Enter your choice please:");
        System.out.println();
        System.out.println("1.Encrypt the text");
        System.out.println("2.Decrypt the text");
        System.out.println("3.Decrypt the text, offset is not known");
        System.out.println("4.Exit the program");
        int choice = keyboard.nextInt();

        if (choice == 1) {
            text = readTextFromFile(Path.of(ValidatorWithDialog.pathValidation()));
            offset = ValidatorWithDialog.offsetValidation();
            CryptographerRu cryptographerRu = new CryptographerRu(text, offset);
            System.out.println(WRITE_RESULT_IN_FILE);
            String textResult = getCryptText(cryptographerRu);
            sendTextResult(textResult);

        } else if (choice == 2) {
            text = readTextFromFile(Path.of(ValidatorWithDialog.pathValidation()));
            offset = ValidatorWithDialog.offsetValidation();
            CryptographerRu cryptographerRu = new CryptographerRu(text, offset);
            System.out.println(WRITE_RESULT_IN_FILE);
            String textResult = decryptText(cryptographerRu);
            sendTextResult(textResult);

        } else if (choice == 3) {
            text = readTextFromFile(Path.of(ValidatorWithDialog.pathValidation()));
            System.out.println(WRITE_RESULT_IN_FILE + "You can change a right. Most likely option are at the top");
            String textResult = decryptByBruteForce(text);
            sendTextResult(textResult);

        } else {
            System.exit(0);
        }
    }

}
