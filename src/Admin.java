package src;

import java.util.Scanner;

public class Admin extends User {

    private String permissions;
    private Scanner scan;

    Admin(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password,
        Scanner scan
    ) {
        super(id, name, role, username, age, height, password, scan);
        this.scan = scan;

        this.permissions = "Read-Only";
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions() {
        System.out.print("Enter Permissions (e.g., Full-Access) :: ");
        this.permissions = scan.next();
    }

    public void manageUsers() {
        System.out.println("Admin " + getName() + " is now managing users...");
    }

    public void printInfo() {
        super.print();
        System.out.println("--- Admin Details ---");
        System.out.println("Permissions: " + permissions);
        System.out.println("---------------------");
    }
}
