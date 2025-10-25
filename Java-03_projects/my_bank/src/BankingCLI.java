import java.util.Scanner;

public class BankingCLI {

    private final Bank bank;
    private final Database db;
    private final Scanner scanner;

    public BankingCLI(Bank bank, Database db) {
        this.bank = bank;
        this.db = db;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("--- Banking System Application Start ---");
        loadDataFromDatabase();
        runMenuLoop();
        cleanup();
    }

    private void loadDataFromDatabase() {
        System.out.println("\nLoading users from database...");
        User[] users = db.read_db();
        for (User user : users) {
            bank.addUser(user);
        }

        if (users.length == 0) {
            System.out.println(
                "Database is empty. Loading default test data..."
            );
            loadTestData();
            db.sync(bank.getAllUsersAsArray());
        } else {
            System.out.println(
                "Successfully loaded " + users.length + " users from database."
            );
        }
    }

    private void loadTestData() {
        bank.addUser(
            new User(
                "Alice Smith (Admin)",
                "1001",
                "1234",
                "pass123",
                0.0,
                5000.75,
                User.Role.ADMIN
            )
        );
        bank.addUser(
            new User(
                "Bob Johnson",
                "1002",
                "4321",
                "pass456",
                1500.0,
                250.25,
                User.Role.USER
            )
        );
    }

    private void runMenuLoop() {
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            String choice = scanner.nextLine();
            isRunning = handleMenuChoice(choice);
        }
    }

    private void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Show All Users");
        System.out.println("2. View User Details");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Add New User (Admin)");
        System.out.println("6. Remove User (Admin)");
        System.out.println("7. Save & Exit");
        System.out.print("Enter your choice: ");
    }

    private boolean handleMenuChoice(String choice) {
        switch (choice) {
            case "1":
                handleShowAllUsers();
                break;
            case "2":
                handleViewUserDetails();
                break;
            case "3":
                handleDeposit();
                break;
            case "4":
                handleWithdraw();
                break;
            case "5":
                handleAddNewUser();
                break;
            case "6":
                handleRemoveUser();
                break;
            case "7":
                handleSaveAndExit();
                return false;
            default:
                System.out.println(
                    "Error: Invalid choice. Please enter a number between 1 and 7."
                );
                break;
        }
        return true;
    }

    private void handleShowAllUsers() {
        bank.printAllUsers();
    }

    private void handleViewUserDetails() {
        User user = findUserFromInput("Enter user ID to view: ");
        if (user != null) {
            user.showStatus();
        }
    }

    private void handleDeposit() {
        User user = findUserFromInput("Enter user ID for deposit: ");
        if (user == null) return;

        double amount = getAmountFromInput("Enter amount to deposit: ");
        if (amount >= 0) {
            user.deposit(amount);
        }
    }

    private void handleWithdraw() {
        User user = findUserFromInput("Enter user ID for withdrawal: ");
        if (user == null) return;

        System.out.print("Please type your password :: ");
        String input_pass = scanner.nextLine();

        if (!input_pass.equals(user.password)) {
            // System.out.println(
            //     "Password : " + (user.password) + " input : " + (input_pass)
            // );
            System.out.println("Wrong Password");
            return;
        } else {
            double amount = getAmountFromInput("Enter amount to withdraw: ");
            if (amount >= 0) {
                user.withdraw(amount);
            }
        }
    }

    private void handleAddNewUser() {
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
        } else if (!roleInput.equals("USER")) {
            System.out.println("Invalid role. Defaulting to USER.");
        }

        User newUser = new User(name, id, pin, password, 0.0, 0.0, role);
        bank.addUser(newUser);
    }

    private void handleRemoveUser() {
        System.out.print("Enter user ID to remove: ");
        String removeId = scanner.nextLine();
        bank.removeUser(removeId);
    }

    private void handleSaveAndExit() {
        System.out.println("\nSyncing all changes to database file...");
        db.sync(bank.getAllUsersAsArray());
        db.printInfo();
        System.out.println("--- Banking System Application End ---");
    }

    private User findUserFromInput(String prompt) {
        System.out.print(prompt);
        String id = scanner.nextLine();
        User user = bank.findUserById(id);
        if (user == null) {
            System.out.println("Error: User not found.");
        }
        return user;
    }

    private double getAmountFromInput(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid amount. Please enter a number.");
            return -1.0;
        }
    }

    private void cleanup() {
        scanner.close();
        System.out.println("Application closed.");
    }
}
