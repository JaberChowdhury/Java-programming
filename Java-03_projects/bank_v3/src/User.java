import java.util.StringJoiner;

public class User {

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

    public static String encode(String raw_password) {

        String encoded = "";

        for (int i = 0; i < raw_password.length(); i++) {

            char x = raw_password.charAt(i);
            int y = x;
            y += 10;
            char z = (char) y;
            encoded += z;
            if (i != raw_password.length() - 1) {
                encoded += "-|-";
            }

        }
        return encoded;

    }

    public static String decode(String encoded_password) {

        String decoded = "";


        String[] parts = encoded_password.split("-\\|-");

        for (String part : parts) {

            char z = part.charAt(0);

            int y = z;

            y -= 10;

            char x = (char) y;

            decoded += x;
        }

        return decoded;
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