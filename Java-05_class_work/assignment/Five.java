import java.util.Arrays;
import java.util.Scanner;

public class Five {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        scan.close();
    }
}
