package src;

public class Admin extends User {

    private String permissions;

    Admin(
        String id,
        String name,
        RoleType role,
        String username,
        Integer age,
        Float height,
        String password
    ) {
        super(id, name, role, username, age, height, password);
        this.permissions = "Read-Only";
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public void printInfo() {
        super.print();
        System.out.println("--- Admin Details ---");
        System.out.println("Permissions: " + permissions);
        System.out.println("---------------------");
    }
}
