// task 4

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, smallest, second_smallest;


        n = scan.nextInt();
        int[] arr = new int[n];

        arr[0] = scan.nextInt();
        arr[1] = scan.nextInt();


        if (arr[0] < arr[1]) {
            smallest = arr[0];
            second_smallest = arr[1];
        } else {
            smallest = arr[1];
            second_smallest = arr[0];
        }


        for (int i = 2; i < n; i++) {
            arr[i] = scan.nextInt();

            if (smallest > arr[i]) {
                second_smallest = smallest;
                smallest = arr[i];
            }
        }


        System.out.println("Second smallest element is " + second_smallest);
        scan.close();
    }
}
