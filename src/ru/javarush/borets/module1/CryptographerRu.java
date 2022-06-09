package ru.javarush.borets.module1;

import static ru.javarush.borets.module1.AlphabetRu.ALPHABET_RU;
import static ru.javarush.borets.module1.AlphabetRu.CAPACITY_ALPHABET_RU;
import static ru.javarush.borets.module1.RussianWords.RUSSIAN_WORDS;

public class CryptographerRu {
    private String textInput;
    private int offset;
    private static char temp = ' ';


    public CryptographerRu(String textInput, int offset) {
        this.textInput = textInput;
        this.offset = offset;
    }

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(String textInput) {
        this.textInput = textInput;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public static String getCryptText(CryptographerRu cryptographerRu) {
        StringBuilder stringBuilder = new StringBuilder(cryptographerRu.getTextInput().length());
        String text = cryptographerRu.getTextInput().toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (ALPHABET_RU.contains(letter)) {
                int indexLetter = ALPHABET_RU.indexOf(letter);
                int indexNewLetter = (indexLetter + cryptographerRu.getOffset()) % CAPACITY_ALPHABET_RU;

                if (indexNewLetter < 0)
                    indexNewLetter = indexNewLetter + CAPACITY_ALPHABET_RU;

                temp = ALPHABET_RU.get(indexNewLetter);
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    public static String decryptText(CryptographerRu cryptographerRu) {
        int shift = cryptographerRu.getOffset() * (-1);
        cryptographerRu.setOffset(shift);
        return getCryptText(cryptographerRu);
    }

    public static String decryptByBruteForce(String message) {
        String text = message.toLowerCase();
        StringBuilder result = new StringBuilder();
        StringBuilder resultWithAnalyze = new StringBuilder();
        StringBuilder resultAll = new StringBuilder();
        resultWithAnalyze.append("Most likely option are: \n");
        int minOccurrenceFrequency = 2;

        for (int shift = 0; shift < CAPACITY_ALPHABET_RU; shift++) {
            StringBuilder stringBuilder = new StringBuilder(message.length());
            for (int i = 0; i < text.length(); i++) {
                char letter = text.charAt(i);

                if (ALPHABET_RU.contains(letter)) {
                    int indexLetter = ALPHABET_RU.indexOf(letter);
                    int indexNewLetter = (indexLetter - shift) % CAPACITY_ALPHABET_RU;
                    if (indexNewLetter < 0)
                        indexNewLetter = indexNewLetter + CAPACITY_ALPHABET_RU;
                    temp = ALPHABET_RU.get(indexNewLetter);
                }
                stringBuilder.append(temp);
            }

            int count = analyze(stringBuilder.toString());
            if (count > minOccurrenceFrequency) {
                resultWithAnalyze.append("number of occurrences: ").append(count).append("\n").append("ROT").append(shift).append(".")
                        .append(stringBuilder).append("\n").append("********************** \n");

            } else
                resultAll.append("ROT").append(shift).append(".").append(stringBuilder).append("\n");
        }
        result.append(resultWithAnalyze).append(resultAll);

        return result.toString();
    }

    public static int analyze(String message) {
        int count = 0;
        String messageWithoutSpace = message.trim();
        for (String word : RUSSIAN_WORDS) {
            if (messageWithoutSpace.contains(word)) {
                count++;
            }
        }
        return count;
    }
}


