package ru.javarush.borets.module1;

import java.io.IOException;
import java.nio.file.Path;

import static ru.javarush.borets.module1.CryptographerRu.*;
import static ru.javarush.borets.module1.FileInputOutput.getText;
import static ru.javarush.borets.module1.Menu.showMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        showMenu();

        //команды для тестирования без меню
        //String textInput = getText(Path.of("input.txt"));
        //CryptographerRu cryptographerRu = new CryptographerRu(textInput, 3);
        //getCryptText(cryptographerRu);
        // decryptText(cryptographerRu);
        //decryptByBruteForce(textInput);

    }

}

