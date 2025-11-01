import java.util.Scanner;

public class Nine {

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


    public static int[][] multiply_two_matrix(int[][] a, int[][] b) {
        int aRows, aCols, bRows, bCols;
        aRows = a.length;
        aCols = a[0].length;
        bRows = b.length;
        bCols = b[0].length;

        if (aCols != bRows) {
            System.out.println("Error: Matrices cannot be multiplied. Columns of A must equal rows of B.");
            return null;
        }

        int[][] result = new int[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < aCols; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Now enter 1st matrix:");
        int[][] matrixA = take_matrix(scan);
        System.out.println("Now enter 2nd matrix:");
        int[][] matrixB = take_matrix(scan);

        int[][] result = multiply_two_matrix(matrixA, matrixB);
        print_matrix(result);
        scan.close();
    }
}
