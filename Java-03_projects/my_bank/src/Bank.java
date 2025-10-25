import java.util.ArrayList;

public class Bank {

    private ArrayList<User> users;

    public Bank() {
        this.users = new ArrayList<>();
        System.out.println("Bank created. Ready to manage users.");
    }

    public boolean addUser(User newUser) {
        if (findUserById(newUser.id) != null) {
            System.out.println(
                "Error: User with ID " +
                    newUser.id +
                    " already exists. Cannot add."
            );
            return false;
        }

        this.users.add(newUser);
        System.out.println(
            "User added: " + newUser.name + " (" + newUser.role + ")"
        );
        return true;
    }

    public boolean removeUser(String userId) {
        User userToRemove = findUserById(userId);

        if (userToRemove != null) {
            this.users.remove(userToRemove);
            System.out.println("User removed: " + userToRemove.name);
            return true;
        } else {
            System.out.println(
                "Error: User with ID " + userId + " not found. Cannot remove."
            );
            return false;
        }
    }

    public User findUserById(String userId) {
        for (User user : this.users) {
            if (user.id.equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public User[] getAllUsersAsArray() {
        return this.users.toArray(new User[0]);
    }

    public void printAllUsers() {
        System.out.println("--- Current Bank Users (" + users.size() + ") ---");
        for (User user : this.users) {
            System.out.println(
                " - " +
                    user.name +
                    " (ID: " +
                    user.id +
                    ", Role: " +
                    user.role +
                    ")"
            );
        }
        System.out.println("-----------------------------");
    }

    // for testing purpose
    public static void main(String[] args) {
        System.out.println("--- Testing Bank Class ---");

        Bank testBank = new Bank();

        User admin = new User(
            "Admin",
            "admin001",
            "0000",
            "admin_pass",
            0,
            999999,
            User.Role.ADMIN
        );
        User user1 = new User(
            "Alice",
            "u1001",
            "1234",
            "pass1",
            0,
            500,
            User.Role.USER
        );
        User user2 = new User(
            "Bob",
            "u1002",
            "4321",
            "pass2",
            0,
            250,
            User.Role.USER
        );

        System.out.println("\nAdding users...");
        testBank.addUser(admin);
        testBank.addUser(user1);
        testBank.addUser(user2);
        testBank.addUser(user1);

        testBank.printAllUsers();

        System.out.println("\nFinding user u1001...");
        User foundUser = testBank.findUserById("u1001");
        if (foundUser != null) {
            System.out.println("Found: " + foundUser.name);
        } else {
            System.out.println("User not found.");
        }

        System.out.println("\nRemoving users...");
        testBank.removeUser("u1002");
        testBank.removeUser("u9999");

        testBank.printAllUsers();

        System.out.println("--------------------------");
    }
}
