// task 01
public class One {

    public static void main(String[] args) {
        int data[] = {218, 31, 43, 654, 576, 7896, 24};
        int new_array[] = data.clone();

        for (int d : new_array) {
            System.out.print(d + " ");
        }
    }
}
