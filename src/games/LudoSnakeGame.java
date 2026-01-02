package games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import utils.Logger;

class Player {

    String name;
    int position;
    String symbol;

    public Player(String name, int id) {
        this.name = name;
        this.position = 1;
        this.symbol = "P" + id;
    }
}

public class LudoSnakeGame {

    private final int WIN_POINT = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private List<Player> players;

    public LudoSnakeGame() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new ArrayList<>();
        initBoard();
    }

    private void initBoard() {
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(51, 67);
        ladders.put(80, 99);
        ladders.put(72, 91);

        snakes.put(17, 7);
        snakes.put(54, 34);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 36);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 79);
    }

    private void renderBoard() {
        Logger.print(
            "----------------------------------------------------------------------",
            Logger.YELLOW
        );
        for (int i = 9; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 1; j <= 10; j++) {
                    int val = i * 10 + j;
                    printSingleCell(val);
                }
            } else {
                for (int j = 10; j >= 1; j--) {
                    int val = i * 10 + j;
                    printSingleCell(val);
                }
            }
            Logger.print("");
        }
        Logger.print(
            "----------------------------------------------------------------------",
            Logger.YELLOW
        );
        Logger.print("Legend: ", Logger.PURPLE);
        Logger.p("[ S## ]", Logger.RED);
        Logger.p(" = Snake  ", Logger.RESET);
        Logger.p("[ L## ]", Logger.GREEN);
        Logger.p(" = Ladder  ", Logger.RESET);
        Logger.p("[ P#  ]", Logger.CYAN);
        Logger.print(" = Player", Logger.RESET);
    }

    private void printSingleCell(int val) {
        String display = String.valueOf(val);
        String color = Logger.RESET;

        String playerStr = "";
        for (Player p : players) {
            if (p.position == val) {
                playerStr += p.symbol;
            }
        }

        if (!playerStr.isEmpty()) {
            display = playerStr;
            color = Logger.CYAN;
        } else if (snakes.containsKey(val)) {
            display = "S" + val;
            color = Logger.RED;
        } else if (ladders.containsKey(val)) {
            display = "L" + val;
            color = Logger.GREEN;
        }

        Logger.p("[ ", Logger.YELLOW);

        String padded = String.format("%-3s", display);
        Logger.p(padded, color);

        Logger.p(" ]", Logger.YELLOW);
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        Logger.clear();
        Logger.printCenter("LUDO SNAKE GAME", 50, Logger.PURPLE);

        int n = 0;
        while (n < 2) {
            Logger.p("Enter number of players (min 2): ", Logger.CYAN);
            if (scan.hasNextInt()) {
                n = scan.nextInt();
            } else {
                scan.next();
            }
        }
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            Logger.p("Enter name for Player " + (i + 1) + ": ", Logger.BLUE);
            String name = scan.nextLine();
            players.add(new Player(name, i + 1));
        }

        boolean gameRunning = true;
        Random dice = new Random();
        int currentPlayerIdx = 0;

        while (gameRunning) {
            Player currentPlayer = players.get(currentPlayerIdx);

            Logger.clear();
            renderBoard();

            Logger.print("");
            Logger.print(
                ">> " +
                    currentPlayer.name +
                    "'s Turn (" +
                    currentPlayer.symbol +
                    ")",
                Logger.YELLOW
            );
            Logger.print("Press Enter to Roll Dice...");
            scan.nextLine();

            int roll = dice.nextInt(6) + 1;
            Logger.print("Rolled a " + roll + "!", Logger.PURPLE);

            int newPos = currentPlayer.position + roll;

            if (newPos > WIN_POINT) {
                Logger.print(
                    "Need exact number to finish. Stay put.",
                    Logger.RED
                );
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            } else {
                currentPlayer.position = newPos;

                if (snakes.containsKey(currentPlayer.position)) {
                    Logger.print("OOPS! Bitten by a snake!", Logger.RED);
                    currentPlayer.position = snakes.get(currentPlayer.position);
                } else if (ladders.containsKey(currentPlayer.position)) {
                    Logger.print("YAY! Climbed a ladder!", Logger.GREEN);
                    currentPlayer.position = ladders.get(
                        currentPlayer.position
                    );
                }
            }

            if (currentPlayer.position == WIN_POINT) {
                Logger.clear();
                renderBoard();
                Logger.printCenter(
                    "WINNER WINNER CHICKEN DINNER!",
                    50,
                    Logger.GREEN
                );
                Logger.printCenter(
                    currentPlayer.name.toUpperCase() + " WINS!",
                    50,
                    Logger.CYAN
                );
                gameRunning = false;
            }

            currentPlayerIdx = (currentPlayerIdx + 1) % players.size();

            if (gameRunning) {
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {}
            }
        }
    }
}
