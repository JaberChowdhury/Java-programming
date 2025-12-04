package src;

import java.util.Scanner;

enum RoleType {
    Admin,
    Doctor,
    Patient,
    Staff,
}

public class User {

    private Scanner scan;
    private RoleType role;
    private String id, name, username, password;
    private int age;
    private Float height;

    User(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password,
        Scanner scan
    ) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.username = username;
        this.age = age;
        this.height = height;
        this.password = password;
        this.scan = scan;
    }

    public String getId() {
        return id;
    }

    public void setId(String uniqueid) {
        // System.out.print("Enter a new id :: ");
        this.id = uniqueid;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.print("Enter a new name :: ");
        this.name = scan.nextLine();
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole() {
        System.out.println("Choose role (Admin, Doctor, Patient, Staff) :: ");
        String input = scan.next();
        try {
            this.role = RoleType.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role! Keeping previous role.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        System.out.print("Enter new age :: ");
        if (scan.hasNextInt()) {
            this.age = scan.nextInt();
        } else {
            System.out.println("Invalid number!");
            scan.next();
        }
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight() {
        System.out.print("Enter new height :: ");
        if (scan.hasNextFloat()) {
            this.height = scan.nextFloat();
        } else {
            System.out.println("Invalid number!");
            scan.next();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        System.out.print("Enter new username :: ");
        this.username = scan.next();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        System.out.print("Enter new password :: ");
        this.password = scan.next();
    }

    public void print() {
        System.out.println("-------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Username: " + username);
        System.out.println("-------------------------");
    }
}
