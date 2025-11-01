// task 3

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, largest, second_largest;


        n = scan.nextInt();
        int[] arr = new int[n];

        arr[0] = scan.nextInt();
        arr[1] = scan.nextInt();


        if(arr[0] > arr[1]){
            largest = arr[0];
            second_largest = arr[1];
        }else {
            largest = arr[1];
            second_largest = arr[0];
        }



        for (int i = 2; i < n; i++) {
            arr[i] = scan.nextInt();

            if (largest < arr[i]) {
                second_largest = largest;
                largest = arr[i];
            }
        }


        System.out.println("Second largest element is " + second_largest);
        scan.close();
    }
}
