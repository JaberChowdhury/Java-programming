import java.util.Scanner;

public class Taskthree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int N = scan.nextInt();

        int f = 0, l = 1;

        System.out.print((f) + " "+ (l)+" ");
        for(int i=1;i<=N ;i++){
          int newn = f + l;
          f = l;
          l = newn;
          System.out.print((newn)+" ");
        }


        System.out.println("5");
        scan.close();
    }

}