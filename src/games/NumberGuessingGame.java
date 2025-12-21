package games;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Logger;
import utils.RandomNumber;

public class NumberGuessingGame {

    public static void start() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> gameHistory = new ArrayList<>();

        Logger.clear();
        int round = 1;
        int min = 0,
            max = 10;
        int totalCorrect = 0;

        Logger.printCenter("The game is starting", 50);

        while (true) {
            int rand = RandomNumber.generateRandomNumber(min, max);
            int attemptsUsed = 0;
            int maxAttempts = 5;
            boolean wonRound = false;

            Logger.printCenter("Round " + round, 50);

            while (attemptsUsed < maxAttempts) {
                System.out.print("Guess (" + min + "-" + max + "): ");
                int userSelect = scan.nextInt();
                attemptsUsed++;

                if (userSelect == rand) {
                    Logger.print("Correct!");
                    totalCorrect++;
                    wonRound = true;
                    break;
                } else {
                    if (userSelect > rand) {
                        Logger.print("Too high");
                    } else {
                        Logger.print("Too low");
                    }
                }
            }

            String result = wonRound ? "WON" : "LOST";
            String historyEntry = String.format(
                "Round %d: %s | Target: %d | Attempts: %d",
                round,
                result,
                rand,
                attemptsUsed
            );
            gameHistory.add(historyEntry);

            Logger.print("Next round? (Y/N)");
            String userChoice = scan.next();
            if (userChoice.equalsIgnoreCase("N")) {
                break;
            }

            max += 5;
            round++;
        }

        printSummary(gameHistory, totalCorrect);
    }

    private static void printSummary(
        ArrayList<String> history,
        int totalCorrect
    ) {
        Logger.clear();
        Logger.printCenter(" GAME HISTORY ", 50);
        System.out.println(
            "--------------------------------------------------"
        );
        for (String record : history) {
            System.out.println(record);
        }
        System.out.println(
            "--------------------------------------------------"
        );
        Logger.print("Total Correct Rounds: " + totalCorrect);
    }
}
