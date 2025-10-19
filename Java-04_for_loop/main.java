import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit;
        System.out.print("Enter a suitable limit :: ");
        limit = scanner.nextInt();

        for (int i = 0; i < limit; i++) {
            System.out.printf("%4d\n", i);
        }

        scanner.close();
    }
}
