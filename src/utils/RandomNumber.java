package utils;

public class RandomNumber {

    public static int generateRandomNumber(int min, int max) {
        int x = (int) (Math.random() * (max - min + 1) + min);
        return x;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(generateRandomNumber(10, 12) + "    ");
            }
            System.out.println("");
        }
    }
}
