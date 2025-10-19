package termProject;

import termProject.Calculator;
import termProject.GuessingGame;
import termProject.Logger;

public class App {

    public static void main(String[] args) {
        Logger.welcom();
        // int sum = Calculator.add(12, 23);
        // System.out.println(sum);
        GuessingGame.game();
    }
}
