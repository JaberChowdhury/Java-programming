package src;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Hospital Management System ===");

        while (running) {
            System.out.println("\nSelect a User to Register:");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("3. Staff");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 5) {
                running = false;
                System.out.println("Exiting System...");
                break;
            }

            System.out.print("Enter ID: ");
            String id = sc.next();

            System.out.print("Enter Name (Single word): ");
            String name = sc.next();

            System.out.print("Enter Username: ");
            String username = sc.next();

            System.out.print("Enter Password: ");
            String password = sc.next();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Height: ");
            float height = sc.nextFloat();

            switch (choice) {
                case 1:
                    Patient p = new Patient(
                        id,
                        name,
                        RoleType.Patient,
                        username,
                        age,
                        height,
                        password,
                        sc
                    );
                    System.out.println("\n--- Enter Patient Specifics ---");
                    p.setEmergencyLevel();
                    p.setAdmittedDate();
                    p.setIsReleased();
                    System.out.println("\nResult:");
                    p.printInfo();
                    break;
                case 2:
                    Doctor d = new Doctor(
                        id,
                        name,
                        RoleType.Doctor,
                        username,
                        age,
                        height,
                        password,
                        sc
                    );
                    System.out.println("\n--- Enter Doctor Specifics ---");
                    d.setRank();
                    d.setSpecialization();
                    d.setExperiencedYear();
                    System.out.println("\nResult:");
                    d.printInfo();
                    break;
                case 3:
                    Staff s = new Staff(
                        id,
                        name,
                        RoleType.Staff,
                        username,
                        age,
                        height,
                        password,
                        sc
                    );
                    System.out.println("\n--- Enter Staff Specifics ---");
                    s.setDepartment();
                    s.setShift();
                    System.out.println("\nResult:");
                    s.printInfo();
                    break;
                case 4:
                    Admin a = new Admin(
                        id,
                        name,
                        RoleType.Admin,
                        username,
                        age,
                        height,
                        password,
                        sc
                    );
                    System.out.println("\n--- Enter Admin Specifics ---");
                    a.setPermissions();
                    System.out.println("\nResult:");
                    a.printInfo();
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
