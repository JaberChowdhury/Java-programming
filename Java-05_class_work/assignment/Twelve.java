import java.util.Scanner;

public class Twelve {

    public static int[] add_element(int element, int index, int[] a) {
        int col = a.length;
        int[] result = new int[col + 1];


        result[index] = element;

        for (int i = 0; i < index; i++) {
            result[i] = a[i];
        }

        for (int i = index + 1; i < col + 1; i++) {
            result[i] = a[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = 1, position, element;
        System.out.print("What is the size of the array ? ");
        n = scan.nextInt();

        int[] nums = new int[n];

        System.out.print("Enter n number with space saparated :: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.print("Enter enter element and the position to add (position must be <=n+1) :: ");

        element = scan.nextInt();
        position = scan.nextInt();


        if (position > n + 1 || position < 0) {
            System.out.print("Input is out of range");
        } else {
            int[] result = add_element(element, position, nums);

            for (int d : result) {
                System.out.print(d + " ");
            }
            System.out.println("");
        }
        scan.close();
    }
}
