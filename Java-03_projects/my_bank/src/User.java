import java.util.StringJoiner;

public class User {

    public enum Role {
        ADMIN,
        USER,
    }

    String name;
    String id;
    String pin;
    String password;
    double loan;
    double amount;
    Role role;

    public User(
        String name,
        String id,
        String pin,
        String password,
        double loan,
        double amount,
        Role role
    ) {
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
        System.out.println(
            "Deposited: $" + depositAmount + ". New balance: $" + this.amount
        );
        return true;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (withdrawAmount > this.amount) {
            System.out.println(
                "Withdrawal failed: Insufficient funds. Current balance: $" +
                    this.amount
            );
            return false;
        }
        this.amount -= withdrawAmount;
        System.out.println(
            "Withdrew: $" + withdrawAmount + ". New balance: $" + this.amount
        );
        return true;
    }

    public void takeLoan(double loanAmount) {
        if (loanAmount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }
        this.loan += loanAmount;
        this.amount += loanAmount;
        System.out.println(
            "Took loan: $" +
                loanAmount +
                ". New balance: $" +
                this.amount +
                ". Total debt: $" +
                this.loan
        );
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
        StringJoiner sj = new StringJoiner(",");
        sj.add(this.name);
        sj.add(this.id);
        sj.add(this.pin);
        sj.add(this.password);
        sj.add(String.valueOf(this.loan));
        sj.add(String.valueOf(this.amount));
        sj.add(this.role.toString());
        return sj.toString();
    }

    public static User fromCsvString(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            System.err.println("Cannot parse empty or null CSV line.");
            return null;
        }

        String[] parts = csvLine.split(",");

        if (parts.length != 7) {
            System.err.println(
                "Invalid CSV string format. Expected 7 fields, but got " +
                    parts.length +
                    " for line: " +
                    csvLine
            );
            return null;
        }

        try {
            String name = parts[0];
            String id = parts[1];
            String pin = parts[2];
            String password = parts[3];
            double loan = Double.parseDouble(parts[4]);
            double amount = Double.parseDouble(parts[5]);
            Role role = Role.valueOf(parts[6].toUpperCase());

            return new User(name, id, pin, password, loan, amount, role);
        } catch (NumberFormatException e) {
            System.err.println(
                "Failed to parse numeric value (loan or amount) from CSV: " +
                    e.getMessage()
            );
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println(
                "Failed to parse Role from CSV. Invalid role string: " +
                    parts[6]
            );
            return null;
        } catch (Exception e) {
            System.err.println(
                "An unexpected error occurred during CSV parsing: " +
                    e.getMessage()
            );
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Testing User Class ---");

        User testUser = new User(
            "Test User",
            "t100",
            "1234",
            "pass123",
            0.0,
            100.0,
            Role.USER
        );
        testUser.showStatus();

        System.out.println("\nTesting deposit...");
        testUser.deposit(50.0);
        testUser.deposit(-10.0);

        System.out.println("\nTesting withdraw...");
        testUser.withdraw(25.0);
        testUser.withdraw(200.0);

        System.out.println("\nTesting loan...");
        testUser.takeLoan(1000.0);

        System.out.println("\nTesting updates...");
        testUser.updatePin("9876");
        testUser.updatePassword("newPass!");

        System.out.println("\nFinal Status:");
        testUser.showStatus();

        System.out.println("\nTesting CSV output:");
        String csvData = testUser.toCsvString();
        System.out.println(csvData);

        System.out.println("\nTesting CSV parsing (fromCsvString):");
        User parsedUser = User.fromCsvString(csvData);

        if (parsedUser != null) {
            System.out.println("Parsed user successfully:");
            parsedUser.showStatus();
        } else {
            System.out.println("Failed to parse user from CSV.");
        }

        System.out.println("\nTesting invalid CSV inputs:");
        User.fromCsvString("a,b,c");
        User.fromCsvString("a,b,c,d,not-a-double,f,USER");
        User.fromCsvString("a,b,c,d,1.0,2.0,INVALID_ROLE");

        System.out.println("--------------------------");
    }
}
