package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static ru.javarush.borets.module1.CryptographerRu.*;
import static ru.javarush.borets.module1.FileInputOutput.getText;
import static ru.javarush.borets.module1.FileInputOutput.sendTextResult;

public class Menu implements Validator {
    public static Scanner keyboard = new Scanner(System.in);

    public static void showMenu() throws IOException {
        System.out.println("************************");
        System.out.println(" Enter your choice please:");
        System.out.println();
        System.out.println("1.Encrypt the text");
        System.out.println("2.Decrypt the text");
        System.out.println("3.Decrypt the text, offset is not known");
        System.out.println("4.Exit the program");
        int choice = keyboard.nextInt();

        if (choice == 1) {
            String text = getText(Path.of(Validator.pathValidation()));
            int offset = Validator.offsetValidation();
            CryptographerRu cryptographerRu = new CryptographerRu(text, offset);
            System.out.println("Thank you. Result will be write in output.txt");
            String textResult = getCryptText(cryptographerRu);
            sendTextResult(textResult);

        } else if (choice == 2) {
            String text = getText(Path.of(Validator.pathValidation()));
            int offset = Validator.offsetValidation();
            CryptographerRu cryptographerRu = new CryptographerRu(text, offset);
            System.out.println("Thank you. Result will be write in output.txt");
            String textResult = decryptText(cryptographerRu);
            sendTextResult(textResult);

        } else if (choice == 3) {
            String text = getText(Path.of(Validator.pathValidation()));
            System.out.println("Result will be write in output.txt. You can change a right. Most likely option are at the top");
            String textResult = decryptByBruteForce(text);
            sendTextResult(textResult);

        } else {
            System.exit(0);
        }
    }

}
