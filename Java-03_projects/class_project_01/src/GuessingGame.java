package termProject;

import java.util.Random;
import java.util.Scanner;

class Data {

    int user = 0;
    int computer = 0;
    boolean isWin = false;

    public Data(int user_value, int computer_value, boolean isWin_value) {
        this.user = user_value;
        this.computer = computer_value;
        this.isWin = isWin_value;
    }
}

public class GuessingGame {

    public static void get_Suggestion(int val) {
        if (val % 2 == 0) {
            System.out.println("Guess a even number");
        } else {
            System.out.println("Guess a odd number");
        }
    }

    public static void game() {
        Scanner scan = new Scanner(System.in);
        int flag = 5;
        Data[] results = new Data[flag];
        while (flag > 0) {
            Random random = new Random();
            int userSelect,
                min = 1,
                max = 10,
                choice = 0;
            int randomNumber = random.nextInt(max) + min;

            System.out.println(
                "Make a choice .\n 1. Enter your guessed number\n 2. get a free suggestion"
            );
            System.out.print("=>");
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.print("Please enter a number between 1 and 10 :");
                userSelect = scan.nextInt();
                while (!(userSelect >= min && userSelect <= max)) {
                    System.out.print("Wrong input try again : ");
                    userSelect = scan.nextInt();
                }
                // check the result
                if (userSelect == randomNumber) {
                    results[5 - flag] = new Data(
                        userSelect,
                        randomNumber,
                        true
                    );
                } else {
                    results[5 - flag] = new Data(
                        userSelect,
                        randomNumber,
                        false
                    );
                }
            } else if (choice == 2) {
                get_Suggestion(randomNumber);
            } else {
                System.out.println("You need basic education bro");
            }
            flag--;
        }
        scan.close();

        // print result
        for (Data d : results) {
            System.out.println(
                "User : " +
                    d.user +
                    " | Computer : " +
                    d.computer +
                    " | Win_status : " +
                    (d.isWin ? "Won" : "lose")
            );
        }
    }
}
