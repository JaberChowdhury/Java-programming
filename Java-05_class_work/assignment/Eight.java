import java.util.Scanner;

public class Eight {
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

    public static boolean isEqualMatrix(int[][] matrixA, int[][] matrixB) {
        if (matrixA == null || matrixB == null) {
            return false;
        }

        if (matrixA.length != matrixB.length) {
            return false;
        }

        for (int i = 0; i < matrixA.length; i++) {
            if (matrixA[i].length != matrixB[i].length) {
                return false;
            }
        }

        return true;
    }

    public static int[][] subtract_two_matrix(int[][] a, int[][] b) {
        int row = a.length;
        int[][] result = new int[row][row];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = a[i][j] - b[i][j];
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


        if (isEqualMatrix(matrixA, matrixB)) {
            int[][] result = subtract_two_matrix(matrixA, matrixB);
            System.out.println("Result of the matrix subtraction");
            print_matrix(result);
        }

        scan.close();
    }
}
