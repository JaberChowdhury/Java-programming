import java.util.Scanner;

public class Fourteen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, search, flag = 0;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        search = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == search) {
                System.out.println("Element found at position: " + (i + 1));
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("Element not found!");
        }

        sc.close();
    }
}
