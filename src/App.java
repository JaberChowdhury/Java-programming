import games.NumberGuessingGame;
import java.util.Scanner;
import utils.Logger;

public class App {

    static String[] games = {
        "Number Guessing Game",
        "Word Guessing Game",
        "Memory Game",
        "Tic-tac-toe",
        "Rock Paper Sissor",
        "Mestry Hunt Game",
        "Truth Dare Game",
        "Sudoku",
        "Ludo Snake Game",
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selected = 0;
        while (!(selected >= 1 && selected <= 9)) {
            Logger.clear();
            Logger.printCenter("hi", 50);
            Logger.print("Choose a game to play");
            int i = 1;
            for (String game : games) {
                Logger.print("[" + i + "]=> " + game);
                i++;
            }
            Logger.p("[?]:");
            selected = scan.nextInt();
            Logger.print("Selected [" + selected + "]");
        }

        switch (selected) {
            case 1:
                NumberGuessingGame.start();
                break;
            case 2:
                Logger.print("coming soon....");
                break;
            case 3:
                Logger.print("coming soon....");
                break;
            case 4:
                Logger.print("coming soon....");
                break;
            case 5:
                Logger.print("coming soon....");
                break;
            case 6:
                Logger.print("coming soon....");
                break;
            case 7:
                Logger.print("coming soon....");
                break;
            case 8:
                Logger.print("coming soon....");
                break;
            case 9:
                Logger.print("coming soon....");
                break;
            default:
                Logger.print("How did you do this ??");
        }

        scan.close();
    }
}
