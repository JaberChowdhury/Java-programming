package games;

import java.util.Random;
import java.util.Scanner;
import utils.Logger;

public class TruthAndDareGame {

    public void start() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] truthQuestions = {
            "What is your biggest fear?",
            "Who was your first crush?",
            "Have you ever lied to your best friend?",
            "What is your biggest secret?",
            "Most embarrassed situation infront of your parents",
        };

        String[] dareTasks = {
            "Only answer yes for the next hour",
            "Sing a song loudly",
            "Do 10 push-ups",
            "Dance for 30 seconds",
            "Say something funny",
        };

        Logger.p("How many players? : ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();

            if (n < 2) {
                Logger.print("At least 2 players needed!");
                return;
            }

            String[] players = new String[n];
            for (int i = 0; i < n; i++) {
                Logger.p("Enter player " + (i + 1) + " name: ");
                players[i] = sc.nextLine();
            }

            int playAgain = 1;

            while (playAgain == 1) {
                int p1 = rand.nextInt(n);
                int p2;
                do {
                    p2 = rand.nextInt(n);
                } while (p1 == p2);

                Logger.print("");
                Logger.print("Bottle Spinning...");
                Logger.print(
                    players[p1] + " will give Truth/Dare to " + players[p2]
                );

                Logger.p(players[p2] + ", choose Truth or Dare (T/D): ");
                String input = sc.next();
                char choice = input.charAt(0);
                sc.nextLine();

                Logger.p(
                    "Press 1: You give question | Press 2: Computer gives question : "
                );
                int giver = 0;
                if (sc.hasNextInt()) {
                    giver = sc.nextInt();
                }
                sc.nextLine();

                if (choice == 'T' || choice == 't') {
                    if (giver == 1) {
                        Logger.print(
                            "You chose to give your own TRUTH question."
                        );
                    } else {
                        int q = rand.nextInt(truthQuestions.length);
                        Logger.print("Computer asks (Truth): ");
                        Logger.print(truthQuestions[q]);
                    }
                } else if (choice == 'D' || choice == 'd') {
                    if (giver == 1) {
                        Logger.print("You chose to give your own DARE task.");
                    } else {
                        int d = rand.nextInt(dareTasks.length);
                        Logger.print("Computer gives (Dare): ");
                        Logger.print(dareTasks[d]);
                    }
                } else {
                    Logger.print("Invalid choice!");
                }

                Logger.p("");
                Logger.p("Press 1 to Play Again, 0 to Exit: ");
                if (sc.hasNextInt()) {
                    playAgain = sc.nextInt();
                } else {
                    playAgain = 0;
                }
                sc.nextLine();
            }

            Logger.print("");
            Logger.print(" Game Over! Thanks for playing.");
        } else {
            Logger.print("Invalid input for number of players.");
        }
        sc.close();
    }
}
