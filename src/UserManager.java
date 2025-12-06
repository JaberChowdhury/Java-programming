package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {

    private List<User> users;
    private Scanner scan;

    public UserManager(Scanner scan) {
        this.users = new ArrayList<>();
        this.scan = scan;
    }

    public void addUser() {
        System.out.println("\nSelect User Type:");
        System.out.println("1. Patient");
        System.out.println("2. Doctor");
        System.out.println("3. Staff");
        System.out.println("4. Admin");
        System.out.print("Enter choice: ");
        int choice = scan.nextInt();

        System.out.print("Enter ID: ");
        String id = scan.next();
        if (findUserById(id) != null) {
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Username: ");
        String username = scan.next();
        System.out.print("Enter Password: ");
        String password = scan.next();
        System.out.print("Enter Age: ");
        int age = scan.nextInt();
        System.out.print("Enter Height: ");
        float height = scan.nextFloat();

        User newUser = null;

        switch (choice) {
            case 1:
                Patient p = new Patient(
                    id,
                    name,
                    RoleType.Patient,
                    username,
                    age,
                    height,
                    password
                );
                updatePatientSpecifics(p);
                newUser = p;
                break;
            case 2:
                Doctor d = new Doctor(
                    id,
                    name,
                    RoleType.Doctor,
                    username,
                    age,
                    height,
                    password
                );
                updateDoctorSpecifics(d);
                newUser = d;
                break;
            case 3:
                Staff s = new Staff(
                    id,
                    name,
                    RoleType.Staff,
                    username,
                    age,
                    height,
                    password
                );
                updateStaffSpecifics(s);
                newUser = s;
                break;
            case 4:
                Admin a = new Admin(
                    id,
                    name,
                    RoleType.Admin,
                    username,
                    age,
                    height,
                    password
                );
                updateAdminSpecifics(a);
                newUser = a;
                break;
            default:
                System.out.println("Invalid Type selected.");
                return;
        }

        users.add(newUser);
        System.out.println("User added successfully.");
    }

    public void updateUser() {
        System.out.print("Enter User ID to update: ");
        String id = scan.next();
        User user = findUserById(id);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Updating General Info for " + user.getName());
        System.out.print("Enter New Name: ");
        user.setName(scan.next());
        System.out.print("Enter New Age: ");
        user.setAge(scan.nextInt());
        System.out.print("Enter New Height: ");
        user.setHeight(scan.nextFloat());

        if (user instanceof Patient) {
            updatePatientSpecifics((Patient) user);
        } else if (user instanceof Doctor) {
            updateDoctorSpecifics((Doctor) user);
        } else if (user instanceof Staff) {
            updateStaffSpecifics((Staff) user);
        } else if (user instanceof Admin) {
            updateAdminSpecifics((Admin) user);
        }
        System.out.println("User updated successfully.");
    }

    public void deleteUser() {
        System.out.print("Enter User ID to delete: ");
        String id = scan.next();
        User user = findUserById(id);

        if (user != null) {
            users.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User u : users) {
                u.printInfo();
            }
        }
    }

    private User findUserById(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    private void updatePatientSpecifics(Patient p) {
        System.out.println("--- Update Patient Specifics ---");
        System.out.println("Select Emergency Level (Serious, Major, Simple): ");
        try {
            p.setEmergencyLevel(EmergencyLevel.valueOf(scan.next()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid level. Defaulting to Simple.");
            p.setEmergencyLevel(EmergencyLevel.Simple);
        }

        System.out.print("Enter Admitted Date: ");
        p.setAdmittedDate(scan.next());

        System.out.print("Is Released? (true/false): ");
        boolean released = scan.nextBoolean();
        p.setIsReleased(released);

        if (released) {
            System.out.print("Enter Release Date: ");
            p.setReleaseDate(scan.next());
        }
    }

    private void updateDoctorSpecifics(Doctor d) {
        System.out.println("--- Update Doctor Specifics ---");
        System.out.println("Select Rank (Senior, Junior, Intern): ");
        try {
            d.setRank(RankLevel.valueOf(scan.next()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid rank. Defaulting to Intern.");
            d.setRank(RankLevel.Intern);
        }
        System.out.print("Enter Specialization: ");
        d.setSpecialization(scan.next());
        System.out.print("Enter Experience Years: ");
        d.setExperiencedYear(scan.nextInt());
    }

    private void updateStaffSpecifics(Staff s) {
        System.out.println("--- Update Staff Specifics ---");
        System.out.print("Enter Department: ");
        s.setDepartment(scan.next());
        System.out.print("Enter Shift (Day/Night): ");
        s.setShift(scan.next());
    }

    private void updateAdminSpecifics(Admin a) {
        System.out.println("--- Update Admin Specifics ---");
        System.out.print("Enter Permissions: ");
        a.setPermissions(scan.next());
    }
}
