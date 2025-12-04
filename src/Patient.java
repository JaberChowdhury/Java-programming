package src;

import java.util.Scanner;

enum EmergencyLevel {
    Serious,
    Major,
    Simple,
}

public class Patient extends User {

    private EmergencyLevel emergencyLevel;
    private boolean isReleased;
    private String releaseDate;
    private String admittedDate;
    private Scanner scan;

    Patient(
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

        this.emergencyLevel = EmergencyLevel.Simple;
        this.isReleased = false;
        this.admittedDate = "Pending";
        this.releaseDate = "N/A";
    }

    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel() {
        System.out.println(
            "Select Emergency Level (Serious, Major, Simple) :: "
        );
        String input = scan.next();
        try {
            this.emergencyLevel = EmergencyLevel.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid level! Defaulting to Simple.");
            this.emergencyLevel = EmergencyLevel.Simple;
        }
    }

    public boolean getIsReleased() {
        return isReleased;
    }

    public void setIsReleased() {
        System.out.print("Is the patient released? (true/false) :: ");
        if (scan.hasNextBoolean()) {
            this.isReleased = scan.nextBoolean();
        } else {
            System.out.println("Invalid input! Enter true or false.");
            scan.next();
        }
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate() {
        System.out.print("Enter Release Date (e.g., 2025-12-01) :: ");
        this.releaseDate = scan.next();
    }

    public String getAdmittedDate() {
        return admittedDate;
    }

    public void setAdmittedDate() {
        System.out.print("Enter Admitted Date (e.g., 2025-11-20) :: ");
        this.admittedDate = scan.next();
    }

    public void printInfo() {
        super.print();

        System.out.println("--- Patient Details ---");
        System.out.println("Emergency Level: " + emergencyLevel);
        System.out.println("Admitted Date: " + admittedDate);
        System.out.println("Released: " + (isReleased ? "Yes" : "No"));
        if (isReleased) {
            System.out.println("Release Date: " + releaseDate);
        }
        System.out.println("-----------------------");
    }
}
