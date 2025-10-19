import java.util.Scanner;

public class EvenOddSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit, odd_sum = 0, even_sum = 0;
        System.out.print("Enter the limit :: ");
        limit = scanner.nextInt();

        for (int i = 0; i < limit; i++) {
            if (i % 2 == 0) {
                even_sum += i;
            } else {
                odd_sum += i;
            }
        }

        System.out.println("\nLimit :: " + limit);
        System.out.println("Sum of odd values :: " + odd_sum);
        System.out.println("Sum of even values :: " + even_sum);

        scanner.close();
    }
}
