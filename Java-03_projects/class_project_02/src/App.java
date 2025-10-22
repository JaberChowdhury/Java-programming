package bank;

import bank.Database;
import bank.User;

public class App {

    // The database instance is created and initialized upon startup
    private Database mydb = new Database("database.txt");

    // The bank system is initialized, passing the database instance to handle
    // persistence (load/save)
    private Bank_system bankSystem = new Bank_system(mydb);

    public static void main(String[] args) {
        // Instantiate App and run the application logic
        App app = new App();
        app.run();
    }

    public void run() {
        System.out.println("\n==============================================");
        System.out.println("--- Welcome to the Simple Banking Application ---");
        System.out.println("==============================================");

        // Shows existing users loaded from the database file
        bankSystem.listAllUserStatuses();

        // --- 1. Create a new User object ---
        User newUser = new User(
                "Alice Smith", // name
                "alice@example.com", // email
                "secure123", // password (will be encoded when saved)
                "account_holder", // role
                35, // age
                2001, // id
                4567, // pin
                987654321, // accountNumber
                12500.50f, // money
                0.00f, // loan
                true // isVip
        );

        // --- 2. Add the user to the Bank System ---
        // This call adds the user to the list AND saves the entire list to
        // database.txt.
        bankSystem.addUser(newUser);

        // --- 3. Demonstrate a transaction ---
        System.out.println("\n--- Demonstrating a Deposit ---");
        newUser.deposite(750.00f);

        // Save the system state after the money change
        bankSystem.addUser(newUser);

        // --- 4. Display final status ---
        bankSystem.listAllUserStatuses();

        System.out.println("==============================================");
        System.out.println("--- Bank Application Finished ---");
        System.out.println("==============================================");
    }
}
