import java.util.Scanner;

public class Eleven {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] a = take_matrix(scan);
        int[][] b = take_matrix(scan);
        if (isEqual(a, b)) {
            System.out.println("Matrices are equal.");
        } else {
            System.out.println("Matrices are not equal.");
        }
        scan.close();
    }

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

    public static boolean isEqual(int[][] a, int[][] b) {
        int arow = a.length, acol = a[0].length, brow = b.length, bcol = b[0].length;
        if (arow != brow || acol != bcol) return false;
        for (int i = 0; i < arow; i++) {
            for (int j = 0; j < acol; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

}
