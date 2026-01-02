package utils;

public class Logger {

    // --- ANSI COLOR CODES ---
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void print(String msg) {
        System.out.println(CYAN + msg + RESET);
    }

    // Custom Color
    public static void print(String msg, String color) {
        System.out.println(color + msg + RESET);
    }

    // --- PRINT (Same Line) - STRING ---

    // Default Color (YELLOW)
    public static void p(String msg) {
        System.out.print(YELLOW + msg + RESET);
    }

    // Custom Color
    public static void p(String msg, String color) {
        System.out.print(color + msg + RESET);
    }

    // --- PRINT (Same Line) - CHAR ---

    // Default Color (YELLOW)
    public static void p(char msg) {
        System.out.print(YELLOW + msg + RESET);
    }

    // Custom Color
    public static void p(char msg, String color) {
        System.out.print(color + msg + RESET);
    }

    // --- PRINT (Same Line) - INT ---

    // Default Color (YELLOW)
    public static void p(int msg) {
        System.out.print(YELLOW + msg + RESET);
    }

    // Custom Color
    public static void p(int msg, String color) {
        System.out.print(color + msg + RESET);
    }

    // --- CENTER TEXT ---

    // Default Color (PURPLE)
    public static void printCenter(String text, int lineWidth) {
        printCenter(text, lineWidth, PURPLE);
    }

    // Custom Color
    public static void printCenter(String text, int lineWidth, String color) {
        int padding = (lineWidth - text.length()) / 2;
        if (padding < 0) {
            System.out.println(color + text + RESET);
            return;
        }
        String spaces = " ".repeat(padding);
        System.out.println(color + spaces + text + RESET);
    }

    public static void clear() {
        System.out.print("\033[2J\033[1;1H");
    }

    public static void printSuccess(String msg) {
        print(msg, GREEN);
    }

    public static void printError(String msg) {
        print(msg, RED);
    }
}
