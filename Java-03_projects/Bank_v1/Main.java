import java.util.ArrayList;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;

import java.util.StringJoiner;

 class Bank {

    private ArrayList<User> users;

    public Bank() {
        this.users = new ArrayList<>();
        System.out.println("Bank created. Ready to manage users.");
    }

    public boolean addUser(User newUser) {
        // First, check if a user with this ID already exists
        if (findUserById(newUser.id) != null) {
            System.out.println("Error: User with ID " + newUser.id + " already exists. Cannot add.");
            return false;
        }

        this.users.add(newUser);
        System.out.println("User added: " + newUser.name + " (" + newUser.role + ")");
        return true;
    }

    public boolean removeUser(String userId) {
        User userToRemove = findUserById(userId);

        if (userToRemove != null) {
            this.users.remove(userToRemove);
            System.out.println("User removed: " + userToRemove.name);
            return true;
        } else {
            System.out.println("Error: User with ID " + userId + " not found. Cannot remove.");
            return false;
        }
    }

    public User findUserById(String userId) {
        // Loop through all users in the list
        for (User user : this.users) {
            if (user.id.equals(userId)) {
                return user; // Found the user
            }
        }
        return null; // Did not find the user
    }

    public User[] getAllUsersAsArray() {
        // new User[0] is just a template to tell the method what type of array to create
        return this.users.toArray(new User[0]);
    }

    public void printAllUsers() {
        System.out.println("--- Current Bank Users (" + users.size() + ") ---");
        for (User user : this.users) {
            System.out.println(" - " + user.name + " (ID: " + user.id + ", Role: " + user.role + ")");
        }
        System.out.println("-----------------------------");
    }


    public static void main(String[] args) {
        System.out.println("--- Testing Bank Class ---");

        Bank testBank = new Bank();

        User admin = new User("Admin", "admin001", "0000", "admin_pass", 0, 999999, User.Role.ADMIN);
        User user1 = new User("Alice", "u1001", "1234", "pass1", 0, 500, User.Role.USER);
        User user2 = new User("Bob", "u1002", "4321", "pass2", 0, 250, User.Role.USER);

        System.out.println("\nAdding users...");
        testBank.addUser(admin);
        testBank.addUser(user1);
        testBank.addUser(user2);
        testBank.addUser(user1); // Test duplicate ID

        testBank.printAllUsers();

        System.out.println("\nFinding user u1001...");
        User foundUser = testBank.findUserById("u1001");
        if (foundUser != null) {
            System.out.println("Found: " + foundUser.name);
        } else {
            System.out.println("User not found.");
        }

        System.out.println("\nRemoving users...");
        testBank.removeUser("u1002"); // Success
        testBank.removeUser("u9999"); // Fail (not found)

        testBank.printAllUsers();

        System.out.println("--------------------------");
    }
}


 class User {

    public enum Role {
        ADMIN,
        USER
    }

    String name;
    String id;
    String pin;
    String password;
    double loan;
    double amount; // total_money
    Role role; // New field for Admin/User role

    public User(String name, String id, String pin, String password, double loan, double amount, Role role) {
        this.name = name;
        this.id = id;
        this.pin = pin;
        this.password = password;
        this.loan = loan;
        this.amount = amount;
        this.role = role;
    }

    public boolean deposit(double depositAmount) {
        if (depositAmount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
        this.amount += depositAmount;
        System.out.println("Deposited: $" + depositAmount + ". New balance: $" + this.amount);
        return true;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (withdrawAmount > this.amount) {
            System.out.println("Withdrawal failed: Insufficient funds. Current balance: $" + this.amount);
            return false;
        }
        this.amount -= withdrawAmount;
        System.out.println("Withdrew: $" + withdrawAmount + ". New balance: $" + this.amount);
        return true;
    }

    public void takeLoan(double loanAmount) {
        if (loanAmount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }
        this.loan += loanAmount;
        this.amount += loanAmount; // The loan money is added to the user's available amount
        System.out.println("Took loan: $" + loanAmount + ". New balance: $" + this.amount + ". Total debt: $" + this.loan);
    }

    public void updatePin(String newPin) {
        this.pin = newPin;
        System.out.println("PIN updated successfully.");
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password updated successfully.");
    }

    public void showStatus() {
        System.out.println("--- User Status for " + this.name + " ---");
        System.out.println("ID: " + this.id);
        System.out.println("Role: " + this.role);
        System.out.println("Balance: $" + this.amount);
        System.out.println("Loan: $" + this.loan);
        System.out.println("PIN: " + this.pin);
        System.out.println("Password: " + this.password);
        System.out.println("-------------------------------------");
    }


    public String toCsvString() {
        // Using StringJoiner for a cleaner way to join with commas
        StringJoiner sj = new StringJoiner(",");
        sj.add(this.name);
        sj.add(this.id);
        sj.add(this.pin);
        sj.add(this.password);
        sj.add(String.valueOf(this.loan));
        sj.add(String.valueOf(this.amount));
        sj.add(this.role.toString()); // Add the role
        return sj.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing User Class ---");

        User testUser = new User("Test User", "t100", "1234", "pass123", 0.0, 100.0, Role.USER);
        testUser.showStatus();

        System.out.println("\nTesting deposit...");
        testUser.deposit(50.0); // Success
        testUser.deposit(-10.0); // Fail

        System.out.println("\nTesting withdraw...");
        testUser.withdraw(25.0); // Success
        testUser.withdraw(200.0); // Fail (insufficient funds)

        System.out.println("\nTesting loan...");
        testUser.takeLoan(1000.0);

        System.out.println("\nTesting updates...");
        testUser.updatePin("9876");
        testUser.updatePassword("newPass!");

        System.out.println("\nFinal Status:");
        testUser.showStatus();

        System.out.println("\nTesting CSV output:");
        System.out.println(testUser.toCsvString());
        System.out.println("--------------------------");
    }
}


 class Database {

    private File databaseFile;

    public Database(String fileName) {
        this.databaseFile = new File(fileName + ".txt");
        try {
            if (this.databaseFile.createNewFile()) {
                System.out.println("Database file created: " + this.databaseFile.getName());
            } else {
                System.out.println("Using existing database file: " + this.databaseFile.getName());
            }
        } catch (IOException e) {
            System.err.println("Error: Could not create or access database file.");
            e.printStackTrace();
        }
    }

    public void sync(User[] users) {
        try (FileWriter fw = new FileWriter(this.databaseFile, false);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("name,id,pin,password,loan,amount,role");

            for (User user : users) {
                pw.println(user.toCsvString());
            }

            System.out.println("Sync complete. Wrote " + users.length + " users.");

        } catch (IOException e) {
            System.err.println("Error: Could not sync data to database file.");
            e.printStackTrace();
        }
    }

    public void printInfo() {
        System.out.println("--- Database Info ---");
        System.out.println("File Name: " + this.databaseFile.getName());
        System.out.println("Full Path: " + this.databaseFile.getAbsolutePath());
        System.out.println("Size: " + this.databaseFile.length() + " bytes");
        System.out.println("Last Modified: " + new Date(this.databaseFile.lastModified()));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Database Class ---");

        Database testDb = new Database("test_db");

        User[] testUsers = {
                new User("Test Admin", "t101", "1111", "pass1", 100.0, 200.0, User.Role.ADMIN),
                new User("Test User", "t102", "2222", "pass2", 0.0, 500.0, User.Role.USER)
        };

        System.out.println("\nSyncing data...");
        testDb.sync(testUsers);

        testDb.printInfo();

        System.out.println("\nTest complete. Check for 'test_db.txt'. It should have 7 columns.");
        System.out.println("------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Banking System Application Start ---");

        Bank bank = new Bank();
        Database db = new Database("banking_db"); // Creates/uses banking_db.txt

        System.out.println("\nCreating and adding users to the bank...");
        bank.addUser(new User("Alice Smith (Admin)", "1001", "1234", "pass123", 0.0, 5000.75, User.Role.ADMIN));
        bank.addUser(new User("Bob Johnson", "1002", "4321", "pass456", 1500.0, 250.25, User.Role.USER));
        bank.addUser(new User("Charlie Lee", "1003", "9876", "pass789", 0.0, 10000.0, User.Role.USER));
        bank.addUser(new User("Jaber", "1343", "987623", "pass3245789", 0.0, 12340000.0, User.Role.USER));


        System.out.println("\nSyncing bank data to file...");
        db.sync(bank.getAllUsersAsArray());
        db.printInfo();

        System.out.println("\nSimulating user action...");
        User bob = bank.findUserById("1002"); // Find Bob in the live bank
        if (bob != null) {
            System.out.println("Found Bob. Bob is depositing $300.");
            bob.deposit(300.0); // Bob's balance is now $550.25
        } else {
            System.out.println("Could not find user '1002'");
        }

        System.out.println("\nSimulating admin action...");
        bank.removeUser("1003"); // Admin removes Charlie

        System.out.println("\nRe-syncing bank data to file after changes...");
        db.sync(bank.getAllUsersAsArray());
        db.printInfo();

        System.out.println("\n--- Banking System Application End ---");
        System.out.println("Check 'banking_db.txt' to see the final data.");
    }
}
