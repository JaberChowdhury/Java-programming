package src;

enum RankLevel {
    Senior,
    Junior,
    Intern,
}

public class Doctor extends User {

    private RankLevel rank;
    private String specialization;
    private int experiencedYear;

    Doctor(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password
    ) {
        super(id, name, role, username, age, height, password);
        this.rank = RankLevel.Intern;
        this.specialization = "General";
        this.experiencedYear = 0;
    }

    public void setRank(RankLevel rank) {
        this.rank = rank;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperiencedYear(int year) {
        this.experiencedYear = year;
    }

    @Override
    public void printInfo() {
        super.print();
        System.out.println("--- Doctor Details ---");
        System.out.println("Rank: " + rank);
        System.out.println("Specialization: " + specialization);
        System.out.println("Experience: " + experiencedYear + " years");
        System.out.println("----------------------");
    }
}
