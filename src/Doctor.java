package src;

import java.util.Scanner;

enum RankLevel {
    Senior,
    Junior,
    Intern,
}

public class Doctor extends User {

    private RankLevel rank;
    private String specialization;
    private int experiencedYear;
    private Scanner scan;

    Doctor(
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

        this.rank = RankLevel.Intern;
        this.specialization = "General";
        this.experiencedYear = 0;
    }

    public RankLevel getRank() {
        return rank;
    }

    public void setRank() {
        System.out.println("Select Rank (Senior, Junior, Intern) :: ");
        String input = scan.next();
        try {
            this.rank = RankLevel.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid rank! Defaulting to Intern.");
            this.rank = RankLevel.Intern;
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization() {
        System.out.print("Enter Specialization :: ");
        this.specialization = scan.next();
    }

    public int getExperiencedYear() {
        return experiencedYear;
    }

    public void setExperiencedYear() {
        System.out.print("Enter Years of Experience :: ");
        if (scan.hasNextInt()) {
            this.experiencedYear = scan.nextInt();
        } else {
            System.out.println("Invalid number!");
            scan.next();
        }
    }

    public void printInfo() {
        super.print();
        System.out.println("--- Doctor Details ---");
        System.out.println("Rank: " + rank);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experiencedYear + " years");
        System.out.println("----------------------");
    }
}
