import java.util.Scanner;

public class Taskone {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int N = scan.nextInt();


        int sum = (N*(N+1))/2;

        float avarage = (float) sum /2;

  System.out.println(sum);
  System.out.println(avarage);
        scan.close();
    }

}