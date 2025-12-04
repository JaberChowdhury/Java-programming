package src;

import java.util.Scanner;

public class Staff extends User {

    private String department;
    private String shift;
    private Scanner scan;

    Staff(
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

        this.department = "General";
        this.shift = "Day";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment() {
        System.out.print("Enter Department :: ");
        this.department = scan.next();
    }

    public String getShift() {
        return shift;
    }

    public void setShift() {
        System.out.print("Enter Shift (Day/Night) :: ");
        this.shift = scan.next();
    }

    public void printInfo() {
        super.print();
        System.out.println("--- Staff Details ---");
        System.out.println("Department: " + department);
        System.out.println("Shift: " + shift);
        System.out.println("---------------------");
    }
}
