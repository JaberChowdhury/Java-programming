import java.util.Scanner;

public class Taskfive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i) + " ");
            }
            System.out.println("");
        }


        for (int i = 1; i <= N; i++) {
            System.out.print((N + 1) + " ");
        }
        scan.close();
    }

}