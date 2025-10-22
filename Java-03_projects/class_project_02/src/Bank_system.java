package bank;

import bank.Database;
import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;

public class Bank_system {

    private List<User> users;
    private Database mydb;

    public Bank_system(Database db) {
        this.mydb = db;
        this.users = new ArrayList<>();
        System.out.println("System: Bank system initialized.");
    }

    public void addUser(User user) {
        if (user != null) {
            this.users.add(user);
            System.out.println(
                "System: Added new user " +
                    user.getName() +
                    " (ID: " +
                    user.getId() +
                    ") to the system."
            );
            mydb:::
        }


    }

    public void listAllUserStatuses() {
        System.out.println(
            "\n===== BANK SYSTEM REPORT: ALL USER STATUSES ====="
        );
        if (users.isEmpty()) {
            System.out.println("No users registered in the system.");
            return;
        }
        for (User user : users) {
            user.status();
        }
        System.out.println("=================================================");
    }
}
