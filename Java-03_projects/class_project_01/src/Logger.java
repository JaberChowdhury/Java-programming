package termProject;

public class Logger {

    public static void print_matrix(int[][] arr[][], int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print("\n");
        }
    }

    // welcome home
    public static void welcom() {
        String art = "welcome to our project";
        System.out.println(art);
    }
}
