package src;

public class Staff extends User {

    private String department;
    private String shift;

    Staff(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password
    ) {
        super(id, name, role, username, age, height, password);
        this.department = "General";
        this.shift = "Day";
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public void printInfo() {
        super.print();
        System.out.println("--- Staff Details ---");
        System.out.println("Department: " + department);
        System.out.println("Shift: " + shift);
        System.out.println("---------------------");
    }
}
