import games.LudoSnakeGame;
import games.MemoryGame;
import games.MysteryHuntGame;
import games.NumberGuessingGame;
import games.QuizGame;
import games.RockPaperScissorsGame;
import games.SudokuGame;
import games.TicTacToeGame;
import games.TruthAndDareGame;
import games.WordGuessingGame;
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
        "Quiz game",
        // "Ludo Snake Game",
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selected = 0;
        while (!(selected >= 1 && selected <= 9)) {
            Logger.clear();
            Logger.printCenter("GameFusion", 50);
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
                WordGuessingGame.start();
                break;
            case 3:
                new MemoryGame().start();
                break;
            case 4:
                new TicTacToeGame().start();
                break;
            case 5:
                new RockPaperScissorsGame().start();
                break;
            case 6:
                new MysteryHuntGame().start();
                break;
            case 7:
                new TruthAndDareGame().start();
                break;
            case 8:
                SudokuGame.start();
                break;
            case 9:
                QuizGame.start();
                break;
            default:
                Logger.print("How did you do this ??");
        }

        scan.close();
    }
}
