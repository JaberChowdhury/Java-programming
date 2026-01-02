package games;

import java.util.Random;
import java.util.Scanner;
import utils.Logger;

public class RockPaperScissorsGame {

    private int playerScore;
    private int computerScore;
    private int draws;
    private int totalRounds;

    public RockPaperScissorsGame() {
        this.playerScore = 0;
        this.computerScore = 0;
        this.draws = 0;
        this.totalRounds = 0;
    }

    private String getMoveName(int move) {
        switch (move) {
            case 1:
                return "ROCK";
            case 2:
                return "PAPER";
            case 3:
                return "SCISSORS";
            default:
                return "UNKNOWN";
        }
    }

    private void printScoreboard() {
        Logger.clear();
        Logger.print("========================================");
        Logger.printCenter("ROCK - PAPER - SCISSORS", 40);
        Logger.print("========================================");
        Logger.printCenter(
            "PLAYER: " +
                playerScore +
                "  |  COMPUTER: " +
                computerScore +
                "  |  DRAWS: " +
                draws,
            40
        );
        Logger.print("========================================");
        Logger.print("");
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        while (running) {
            printScoreboard();
            Logger.print("Choose your weapon:");
            Logger.print("[1] Rock");
            Logger.print("[2] Paper");
            Logger.print("[3] Scissors");
            Logger.print("[0] Exit Game");
            Logger.print("");
            Logger.p("Your Choice > ");

            int userChoice = -1;
            if (scan.hasNextInt()) {
                userChoice = scan.nextInt();
            } else {
                scan.next();
                continue;
            }

            if (userChoice == 0) {
                running = false;
                continue;
            }

            if (userChoice < 1 || userChoice > 3) {
                Logger.print("Invalid choice! Try again.");
                sleep(1000);
                continue;
            }

            Logger.print("");
            Logger.p("Rock... ");
            sleep(400);
            Logger.p("Paper... ");
            sleep(400);
            Logger.p("Scissors... ");
            sleep(400);
            Logger.print("<<<SHOOT!>>>");
            Logger.print("");

            int computerChoice = rand.nextInt(3) + 1;

            String pMove = getMoveName(userChoice);
            String cMove = getMoveName(computerChoice);

            Logger.print("You chose:      " + pMove);
            Logger.print("Computer chose: " + cMove);
            Logger.print("");

            if (userChoice == computerChoice) {
                Logger.print("Result: IT'S A DRAW!");
                draws++;
            } else if (
                (userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)
            ) {
                Logger.print("Result: YOU WIN THIS ROUND!");
                playerScore++;
            } else {
                Logger.print("Result: COMPUTER WINS THIS ROUND!");
                computerScore++;
            }
            totalRounds++;

            Logger.print("");
            Logger.print("Press Enter to continue...");
            try {
                System.in.read();
            } catch (Exception e) {}
        }

        Logger.clear();
        Logger.print("========================================");
        Logger.printCenter("FINAL RESULTS", 40);
        Logger.print("========================================");
        Logger.print(" Total Rounds Played: " + totalRounds);
        Logger.print(" Player Wins:         " + playerScore);
        Logger.print(" Computer Wins:       " + computerScore);
        Logger.print(" Draws:               " + draws);
        Logger.print("========================================");

        if (playerScore > computerScore) {
            Logger.printCenter("CHAMPION! YOU DEFEATED THE MACHINE!", 40);
        } else if (computerScore > playerScore) {
            Logger.printCenter("GAME OVER. THE MACHINE PREVAILED.", 40);
        } else {
            Logger.printCenter("WELL PLAYED. IT WAS AN EVEN MATCH.", 40);
        }
        Logger.print("");

        Logger.print("Press Enter to exit...");
        try {
            System.in.read();
        } catch (Exception e) {}
        scan.close();
    }
}
