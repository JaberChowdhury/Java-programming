package src;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager(sc);
        boolean running = true;

        System.out.println("=== Hospital Management System ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. View All Users");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        userManager.addUser();
                        break;
                    case 2:
                        userManager.updateUser();
                        break;
                    case 3:
                        userManager.deleteUser();
                        break;
                    case 4:
                        userManager.viewAllUsers();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting System...");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        sc.close();
    }
}
