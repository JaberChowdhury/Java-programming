package bank;

public class User {

    private String name, email, password, role;
    private int age, id, pin, accountNumber;
    float money, loan;
    boolean isVip;

    public User(
        String name,
        String email,
        String password,
        String role,
        int age,
        int id,
        int pin,
        int accountNumber,
        float money,
        float loan,
        boolean isVip
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.age = age;
        this.id = id;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.money = money;
        this.loan = loan;
        this.isVip = isVip;
    }

    public void setName(String newName) {
        this.name = newName;
        System.out.println("Name updated to: " + newName);
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
        System.out.println("Email updated to: " + newEmail);
    }

    public void setAge(int newAge) {
        if (newAge > 0 && newAge < 150) {
            this.age = newAge;
            System.out.println("Age updated to: " + newAge);
        } else {
            System.out.println("Age update failed: Invalid age value.");
        }
    }

    public void setPassword(String plainPassword) {
        this.password = plainPassword;
        System.out.println("Password successfully changed.");
    }

    public void setPin(int newPin) {
        if (newPin > 999 && newPin < 10000) {
            this.pin = newPin;
            System.out.println("PIN successfully updated.");
        } else {
            System.out.println("PIN update failed: PIN must be 4 digits.");
        }
    }

    public void deposite(float add_currency) {
        if (add_currency > 0) {
            this.money += add_currency;
            System.out.println(
                "Deposit successful. Added $" +
                    add_currency +
                    " to account " +
                    this.accountNumber
            );
        } else {
            System.out.println("Deposit failed. Amount must be positive.");
        }
    }

    public void withdrawMoney(float withdraw_currency) {
        if (withdraw_currency <= 0) {
            System.out.println("Withdrawal failed. Amount must be positive.");
        } else if (this.money >= withdraw_currency) {
            this.money -= withdraw_currency;
            System.out.println(
                "Withdrawal successful. Remaining balance: $" + this.money
            );
        } else {
            System.out.println(
                "Withdrawal failed. Insufficient funds (Current balance: $" +
                    this.money +
                    ")"
            );
        }
    }

    public void checkBalance() {
        System.out.println(
            "Current Balance for " +
                this.name +
                " (Account #" +
                this.accountNumber +
                "): $" +
                this.money
        );
    }

    public void updateInfo(
        String newName,
        String newEmail,
        int newAge,
        String newPlainPassword,
        int newPin
    ) {
        System.out.println(
            "User information update initiated for ID: " + this.id
        );
        boolean changed = false;

        if (newName != null && !newName.trim().isEmpty()) {
            setName(newName);
            changed = true;
        }

        if (newEmail != null && !newEmail.trim().isEmpty()) {
            setEmail(newEmail);
            changed = true;
        }

        if (newAge != -1) {
            setAge(newAge);
            changed = true;
        }

        if (newPlainPassword != null && !newPlainPassword.trim().isEmpty()) {
            setPassword(newPlainPassword);
            changed = true;
        }

        if (newPin != -1) {
            setPin(newPin);
            changed = true;
        }

        if (changed) {
            System.out.println(
                "User information updated successfully. Changes must be saved to file separately to persist."
            );
        } else {
            System.out.println("No new information provided to update.");
        }
    }

    public String toString() {
        String encodedPass = this.encodePassword();

        return (
            name +
            "," +
            email +
            "," +
            encodedPass +
            "," +
            role +
            "," +
            age +
            "," +
            id +
            "," +
            pin +
            "," +
            accountNumber +
            "," +
            money +
            "," +
            loan +
            "," +
            isVip
        );
    }

    public String encodePassword() {
        StringBuilder encoded = new StringBuilder();
        for (char c : password.toCharArray()) {
            if (encoded.length() > 0) {
                encoded.append("-");
            }
            encoded.append((int) c);
        }
        return encoded.toString();
    }

    public static String decodePassword(String encodedPassword) {
        if (encodedPassword == null || encodedPassword.isEmpty()) {
            return "";
        }

        StringBuilder decoded = new StringBuilder();
        String[] parts = encodedPassword.split("-");

        for (String part : parts) {
            try {
                int asciiValue = Integer.parseInt(part);
                decoded.append((char) asciiValue);
            } catch (NumberFormatException e) {
                System.err.println(
                    "Error decoding password part (invalid number format): " +
                        part
                );
            }
        }
        return decoded.toString();
    }

    public void status() {
        System.out.println("\n--- User Account Status ---");
        System.out.println(
            "Account Holder: " +
                this.name +
                (this.isVip ? " (VIP Customer)" : "")
        );
        System.out.println("Role: " + this.role);
        System.out.println("ID: " + this.id);
        System.out.println("Age: " + this.age);
        System.out.println("Email: " + this.email);
        System.out.println("---------------------------");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.printf("Current Balance: $%.2f%n", this.money);
        System.out.printf("Outstanding Loan: $%.2f%n", this.loan);
        System.out.println("--- End Status ---\n");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public float getMoney() {
        return money;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
