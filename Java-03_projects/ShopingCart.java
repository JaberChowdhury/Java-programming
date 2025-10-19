import java.util.Scanner;

public class ShopingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, item_name;
        int total_item;
        float price;

        System.out.println("please type your name :: ");
        name = scanner.nextLine();
        System.out.println("please type item name :: ");
        item_name = scanner.nextLine();
        System.out.println("How much item you want to buy? :: ");
        total_item = scanner.nextInt();
        System.out.println("Price for each item :: ");
        price = scanner.nextFloat();

        float final_price = total_item * price;

        System.out.println("Hi " + name + ". Thanks for buying our product. " + item_name + " x" + total_item
                + " cost about " + final_price);
        scanner.close();
    }
}
