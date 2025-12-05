package src;

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

    Patient(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password
    ) {
        super(id, name, role, username, age, height, password);
        this.emergencyLevel = EmergencyLevel.Simple;
        this.isReleased = false;
        this.admittedDate = "Pending";
        this.releaseDate = "N/A";
    }

    public void setEmergencyLevel(EmergencyLevel level) {
        this.emergencyLevel = level;
    }

    public void setIsReleased(boolean released) {
        this.isReleased = released;
    }

    public void setReleaseDate(String date) {
        this.releaseDate = date;
    }

    public void setAdmittedDate(String date) {
        this.admittedDate = date;
    }

    @Override
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
