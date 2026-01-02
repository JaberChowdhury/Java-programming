package games;

import java.util.Scanner;
import utils.Logger;

public class TicTacToeGame {

    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printFrame() {
        Logger.print(" Player X  vs  Player O");
        Logger.print("------------------------\n");

        for (int i = 0; i < 3; i++) {
            Logger.print("       |       |       ");

            for (int j = 0; j < 3; j++) {
                Logger.p("   ");
                char val = board[i][j];

                if (val == ' ') {
                    int slotNum = (i * 3) + j + 1;
                    Logger.p("\u001B[30m" + slotNum + "\u001B[0m");
                } else {
                    Logger.p(String.valueOf(val));
                }

                Logger.p("   ");

                if (j < 2) Logger.p("|");
            }
            Logger.print("");

            Logger.print("       |       |       ");

            if (i < 2) {
                Logger.print("-------+-------+-------");
            }
        }
        Logger.print("");
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (
                board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]
            ) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (
                board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]
            ) {
                return true;
            }
        }
        if (
            board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]
        ) return true;
        if (
            board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]
        ) return true;

        return false;
    }

    private int getValidInput(Scanner scan) {
        int index = -1;
        while (true) {
            Logger.p("Player " + currentPlayer + ", enter move (1-9): ");
            if (scan.hasNextInt()) {
                int input = scan.nextInt();
                if (input >= 1 && input <= 9) {
                    int row = (input - 1) / 3;
                    int col = (input - 1) % 3;
                    if (board[row][col] == ' ') {
                        index = input;
                        break;
                    } else {
                        Logger.print("Spot already taken! Try again.");
                    }
                } else {
                    Logger.print("Invalid number. Use 1-9.");
                }
            } else {
                Logger.print("Please enter a number.");
                scan.next();
            }
        }
        return index;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            Logger.clear();
            printFrame();

            int move = getValidInput(scan);
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;

            board[row][col] = currentPlayer;

            if (checkWinner()) {
                Logger.clear();
                printFrame();
                Logger.print("***************************");
                Logger.print("   PLAYER " + currentPlayer + " WINS!");
                Logger.print("***************************");
                gameRunning = false;
            } else if (isBoardFull()) {
                Logger.clear();
                printFrame();
                Logger.print("---------------------------");
                Logger.print("       IT'S A DRAW!");
                Logger.print("---------------------------");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        Logger.print("\nPress Enter to exit...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        new TicTacToeGame().start();
    }
}
