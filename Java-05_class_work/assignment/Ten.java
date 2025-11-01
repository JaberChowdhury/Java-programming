import java.util.Scanner;

public class Ten {
    public static void print_matrix(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        System.out.println("{");
        for (int[] ints : arr) {
            System.out.print("  {");
            for (int j = 0; j < column; j++) {
                System.out.print(ints[j]);
                if (j < column - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("},");
            System.out.println();
        }
        System.out.println("}");
    }

    public static int[][] take_matrix(Scanner scan) {
        System.out.print("Enter row and column size (e.g. 4 6): ");
        int r = scan.nextInt(), c = scan.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Now enter the matrix:");

        for (int i = 0; i < r; i++) {
            System.out.print("Enter the arr[" + i + "]th row: ");
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        return arr;
    }

    public static int[][] transpose_matrix(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = arr[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));

        int[][] A = take_matrix(scan);
        int[][] result = transpose_matrix(A);

        print_matrix(result);
        scan.close();
    }
}
