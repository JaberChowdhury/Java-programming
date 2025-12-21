package games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import utils.Logger;

public class WordGuessingGame {

    private static final String[][] WORD_BANK = {
        { "CAT", "DOG", "SUN", "MAP" },
        { "JAVA", "CODE", "FIRE", "FISH" },
        { "GUESS", "PLANT", "TABLE", "STORM" },
        { "PROGRAM", "PROJECT", "DYNAMIC", "HISTORY", "BANGLADESH" },
    };

    private static String getMaskedWord(String word) {
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 || i == word.length() - 1 || i % 3 == 0) {
                masked.append(word.charAt(i));
            } else {
                masked.append("_");
            }
        }
        return masked.toString();
    }

    private static String formatForDisplay(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(text.charAt(i)).append(" ");
        }
        return result.toString().trim();
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> gameHistory = new ArrayList<>();
        Random rand = new Random();

        int round = 1;
        int totalCorrect = 0;

        Logger.clear();
        Logger.printCenter("WORD GUESSING GAME", 50);

        while (true) {
            int difficulty = Math.min((round - 1) / 2, WORD_BANK.length - 1);
            String targetWord = WORD_BANK[difficulty][rand.nextInt(
                WORD_BANK[difficulty].length
            )];

            int attemptsUsed = 0;
            int maxAttempts = 5;
            boolean wonRound = false;

            String hint = formatForDisplay(getMaskedWord(targetWord));

            Logger.printCenter("Round " + round, 50);
            Logger.print(
                "Hint: " + hint + " (" + targetWord.length() + " letters)"
            );

            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess: ");
                String userGuess = scan.next().toUpperCase();
                attemptsUsed++;

                if (userGuess.equals(targetWord.toUpperCase())) {
                    Logger.print("Correct! The word was " + targetWord);
                    totalCorrect++;
                    wonRound = true;
                    break;
                } else {
                    Logger.print(
                        "Wrong! Attempts remaining: " +
                            (maxAttempts - attemptsUsed)
                    );
                }
            }

            String result = wonRound ? "WON " : "LOST";
            gameHistory.add(
                String.format(
                    "Round %d: %s | Word: %-10s | Attempts: %d",
                    round,
                    result,
                    targetWord,
                    attemptsUsed
                )
            );

            if (!wonRound) {
                Logger.print("Out of attempts! The word was: " + targetWord);
            }

            Logger.print("Play next round? (Y/N)");
            String choice = scan.next();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }

            round++;
        }

        displayHistory(gameHistory, totalCorrect);
    }

    private static void displayHistory(ArrayList<String> history, int total) {
        Logger.clear();
        Logger.printCenter(" FINAL GAME HISTORY ", 50);
        System.out.println(
            "--------------------------------------------------"
        );
        for (String record : history) {
            System.out.println(record);
        }
        System.out.println(
            "--------------------------------------------------"
        );
        Logger.print("Total Words Guessed Correctly: " + total);
    }
}
