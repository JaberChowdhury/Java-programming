import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Banking System Application Start ---");

        Bank bank = new Bank();
        Database db = new Database("banking_db");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLoading initial user data...");
        bank.addUser(new User("Alice Smith (Admin)", "1001", "1234", "pass123", 0.0, 5000.75, User.Role.ADMIN));
        bank.addUser(new User("Bob Johnson", "1002", "4321", "pass456", 1500.0, 250.25, User.Role.USER));
        bank.addUser(new User("Charlie Lee", "1003", "9876", "pass789", 0.0, 10000.0, User.Role.USER));
        bank.addUser(new User("Jaber", "1343", "987623", "pass3245789", 0.0, 12340000.0, User.Role.USER));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Show All Users");
            System.out.println("2. View User Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Add New User (Admin)");
            System.out.println("6. Remove User (Admin)");
            System.out.println("7. Save & Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            User user;

            switch (choice) {
                case "1":
                    bank.printAllUsers();
                    break;

                case "2":
                    System.out.print("Enter user ID to view: ");
                    String viewId = scanner.nextLine();
                    user = bank.findUserById(viewId);
                    if (user != null) {
                        user.showStatus();
                    } else {
                        System.out.println("Error: User not found.");
                    }
                    break;

                case "3":
                    System.out.print("Enter user ID for deposit: ");
                    String depositId = scanner.nextLine();
                    user = bank.findUserById(depositId);
                    if (user != null) {
                        try {
                            System.out.print("Enter amount to deposit: ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            user.deposit(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid amount. Please enter a number.");
                        }
                    } else {
                        System.out.println("Error: User not found.");
                    }
                    break;

                case "4":
                    System.out.print("Enter user ID for withdrawal: ");
                    String withdrawId = scanner.nextLine();
                    user = bank.findUserById(withdrawId);
                    if (user != null) {
                        try {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = Double.parseDouble(scanner.nextLine());
                            user.withdraw(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid amount. Please enter a number.");
                        }
                    } else {
                        System.out.println("Error: User not found.");
                    }
                    break;

                case "5":
                    System.out.println("--- Add New User ---");
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Role (ADMIN or USER): ");
                    String roleInput = scanner.nextLine().toUpperCase();

                    User.Role role = User.Role.USER;
                    if (roleInput.equals("ADMIN")) {
                        role = User.Role.ADMIN;
                    }

                    User newUser = new User(name, id, pin, password, 0.0, 0.0, role);
                    bank.addUser(newUser);
                    break;

                case "6":
                    System.out.print("Enter user ID to remove: ");
                    String removeId = scanner.nextLine();
                    bank.removeUser(removeId);
                    break;

                case "7":
                    System.out.println("\nSyncing all changes to database file...");
                    db.sync(bank.getAllUsersAsArray());
                    db.printInfo();

                    isRunning = false;
                    System.out.println("--- Banking System Application End ---");
                    break;

                default:
                    System.out.println("Error: Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        }

        scanner.close();
    }
}