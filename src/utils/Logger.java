package utils;

public class Logger {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void p(String msg) {
        System.out.print(msg);
    }

    public static void printCenter(String text, int lineWidth) {
        int padding = (lineWidth - text.length()) / 2;
        if (padding < 0) {
            System.out.println(text);
            return;
        }
        String spaces = " ".repeat(padding);
        System.out.println(spaces + text);
    }

    public static void clear() {
        System.out.print("\033[2J\033[1;1H");
    }
}
