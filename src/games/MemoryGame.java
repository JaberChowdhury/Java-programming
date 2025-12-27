package games;

import java.util.Random;
import java.util.Scanner;

class Logger {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void p(String msg) {
        System.out.print(msg);
    }

    public static void p(char msg) {
        System.out.print(msg);
    }

    public static void p(int msg) {
        System.out.print(msg);
    }

    public static void clear() {
        System.out.print("\033[2J\033[1;1H");
    }
}

class Data {

    public char key;
    public int[] pos;
    public boolean selected;

    public Data(char k, int[] p, boolean s) {
        this.key = k;
        this.pos = p;
        this.selected = s;
    }
}

class RandomDataSet {

    public Data[] data;

    RandomDataSet(char[] k) {
        this.data = new Data[18];
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                this.data[temp] = new Data(k[temp], new int[] { i, j }, false);
                temp++;
            }
        }
    }
}

public class MemoryGame {

    public int matrix_size = 20;
    public char[] d;
    public RandomDataSet rd;

    public MemoryGame() {
        this.d = "ABCDEFGHIABCDEFGHI".toCharArray();
        Random rand = new Random();
        for (int i = d.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = d[i];
            d[i] = d[j];
            d[j] = temp;
        }

        this.rd = new RandomDataSet(this.d);
    }

    public void boxes() {
        for (int a = 0; a < 3; a++) {
            for (int r = 0; r < 8; r++) {
                for (int j = 0; j < 6; j++) {
                    int rd_pos = (a * 6) + j;
                    for (int i = 0; i < matrix_size; i++) {
                        if (
                            rd.data[rd_pos].pos[0] == a &&
                            rd.data[rd_pos].pos[1] == j &&
                            rd.data[rd_pos].selected
                        ) {
                            Logger.p(rd.data[rd_pos].key);
                        } else {
                            Logger.p("*");
                        }
                    }
                    Logger.p("   ");
                }
                Logger.print("");
            }
            Logger.print("");
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int getValidInput(Scanner scan) {
        int index = -1;
        while (true) {
            Logger.p("Select box (1-18): ");
            if (scan.hasNextInt()) {
                int input = scan.nextInt();
                index = input - 1;

                if (index < 0 || index >= 18) {
                    Logger.print(
                        "Invalid number! Please choose between 1 and 18."
                    );
                } else if (rd.data[index].selected) {
                    Logger.print(
                        "Box " + input + " is already revealed! Pick another."
                    );
                } else {
                    break;
                }
            } else {
                Logger.print("Please enter a valid integer.");
                scan.next();
            }
        }
        return index;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int matchesFound = 0;
        int totalPairs = 9;
        int total_try = -1;

        while (matchesFound < totalPairs) {
            total_try++;
            Logger.clear();
            Logger.print(
                "Memory Game | Matches Found | Total Try: " +
                    matchesFound +
                    "/" +
                    totalPairs +
                    "/" +
                    total_try
            );
            boxes();

            Logger.print("--- First Pick ---");
            int firstIndex = getValidInput(scan);

            rd.data[firstIndex].selected = true;

            Logger.clear();
            Logger.print(
                "Memory Game | Matches Found | Total Try: " +
                    matchesFound +
                    "/" +
                    totalPairs +
                    "/" +
                    total_try
            );
            boxes();

            Logger.print("--- Second Pick ---");
            int secondIndex = getValidInput(scan);

            rd.data[secondIndex].selected = true;

            Logger.clear();
            Logger.print(
                "Memory Game | Matches Found | Total Try: " +
                    matchesFound +
                    "/" +
                    totalPairs +
                    "/" +
                    total_try
            );
            boxes();

            char key1 = rd.data[firstIndex].key;
            char key2 = rd.data[secondIndex].key;

            if (key1 == key2) {
                Logger.print("MATCH FOUND! (" + key1 + ")");
                matchesFound++;
                sleep(1000);
            } else {
                Logger.print("NO MATCH! (" + key1 + " vs " + key2 + ")");
                Logger.print("Hiding cards in 2 seconds...");
                sleep(2000);

                rd.data[firstIndex].selected = false;
                rd.data[secondIndex].selected = false;
            }
        }

        Logger.clear();
        Logger.print(
            "Memory Game | Matches Found | Total Try: " +
                matchesFound +
                "/" +
                totalPairs +
                "/" +
                total_try
        );
        boxes();
        Logger.print("CONGRATULATIONS! You found all pairs.");
        scan.close();
    }
}
