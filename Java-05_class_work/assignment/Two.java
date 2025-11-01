// task two
import java.util.Scanner;

public class Two {
    public static void main(String[] arge) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        int max = scan.nextInt();
        int min = max;


        for (int i = 1; i < n; i++) {
            arr[i] = scan.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }


        System.out.println("Maximum number is " + max);
        System.out.println("Minimum number is " + min);

        scan.close();
    }
}
