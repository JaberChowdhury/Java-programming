import java.util.Scanner;

public class Taskfour {


    public static boolean isPrime(int d) {
        if (d == 1) {
            return true;
        }
        if (d == 2) {
            return true;
        }
        if (d % 2 == 0) {
            return false;
        }

        for (int i = 3; i < d; i++) {
            if (d % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int N = scan.nextInt();

        int flag = 1, count = 0;

        while (true) {

            if (isPrime(flag)) {
                System.out.print((flag) + " ");
                count++;
            }
            flag++;
            if (count == N) {
                break;
            }
        }


        scan.close();
    }

}