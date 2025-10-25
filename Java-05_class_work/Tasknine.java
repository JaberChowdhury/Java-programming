public class Tasknine {
    public static void printPattern(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("@");
            }

            int middleSpaces = 2 * (n - i);
            for (int k = 1; k <= middleSpaces; k++) {
                System.out.print(" ");
            }

            for (int l = 1; l <= i; l++) {
                System.out.print("@");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(5);
    }
}