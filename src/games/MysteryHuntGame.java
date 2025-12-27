package games;

import java.util.Random;
import java.util.Scanner;
import utils.Logger;

public class MysteryHuntGame {

    private final int SIZE = 5;
    private final char[][] board = new char[SIZE][SIZE];
    private final boolean[][] revealed = new boolean[SIZE][SIZE];

    private int treasureRow, treasureCol;
    private int lives = 3;
    private boolean isGameOver = false;

    private final char UNKNOWN = '~';
    private final char EMPTY = '.';
    private final char TRAP = 'X';
    private final char TREASURE = '$';

    public MysteryHuntGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
                revealed[i][j] = false;
            }
        }
        setupGame();
    }

    private void setupGame() {
        Random rand = new Random();

        treasureRow = rand.nextInt(SIZE);
        treasureCol = rand.nextInt(SIZE);
        board[treasureRow][treasureCol] = TREASURE;

        int trapsPlaced = 0;
        while (trapsPlaced < 3) {
            int r = rand.nextInt(SIZE);
            int c = rand.nextInt(SIZE);

            if (board[r][c] == EMPTY) {
                board[r][c] = TRAP;
                trapsPlaced++;
            }
        }
    }

    private void printBoard(boolean revealAll) {
        Logger.print("   1 2 3 4 5");
        Logger.print("  -----------");

        for (int i = 0; i < SIZE; i++) {
            Logger.p((i + 1) + "| ");
            for (int j = 0; j < SIZE; j++) {
                if (revealAll) {
                    Logger.p(board[i][j] + " ");
                } else if (revealed[i][j]) {
                    Logger.p(board[i][j] + " ");
                } else {
                    Logger.p(UNKNOWN + " ");
                }
            }
            Logger.print("");
        }
        Logger.print("");
    }

    private int getDistanceToTreasure(int r, int c) {
        return Math.abs(r - treasureRow) + Math.abs(c - treasureCol);
    }

    private int getValidInput(Scanner scan, String axis) {
        int val = -1;
        while (true) {
            Logger.p("Enter " + axis + " (1-5): ");
            if (scan.hasNextInt()) {
                val = scan.nextInt();
                if (val >= 1 && val <= 5) {
                    return val - 1;
                }
            } else {
                scan.next();
            }
            Logger.print("Invalid input. Please enter 1-5.");
        }
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        Logger.clear();
        Logger.print("=== MYSTERY HUNT ===");
        Logger.print("Find the Treasure ($) hidden in the grid.");
        Logger.print("Watch out for 3 Traps (X)!");
        Logger.print("Distance clues will guide you.");
        Logger.print("----------------------------------");

        while (!isGameOver && lives > 0) {
            Logger.print("Lives: " + lives);
            printBoard(false);

            int r = getValidInput(scan, "Row");
            int c = getValidInput(scan, "Col");

            Logger.clear();

            if (revealed[r][c]) {
                Logger.print("You already checked that spot!");
                continue;
            }

            revealed[r][c] = true;
            char content = board[r][c];

            if (content == TREASURE) {
                Logger.print("\n*** CONGRATULATIONS! ***");
                Logger.print("You found the Mystery Treasure!");
                isGameOver = true;
            } else if (content == TRAP) {
                lives--;
                Logger.print("\n!!! BOOM !!!");
                Logger.print("You triggered a trap!");
                if (lives == 0) {
                    isGameOver = true;
                    Logger.print("You ran out of lives. Game Over.");
                }
            } else {
                int dist = getDistanceToTreasure(r, c);
                Logger.print("\nNothing here...");

                if (dist <= 1) {
                    Logger.print("CLUE: VERY HOT! (It's right next to you!)");
                } else if (dist <= 2) {
                    Logger.print("CLUE: Warm. You are close.");
                } else {
                    Logger.print("CLUE: Cold. The mystery is far.");
                }
            }
            Logger.print("");
        }

        Logger.print("--- Final Board ---");
        printBoard(true);

        Logger.print("Press Enter to return to menu...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }
}
