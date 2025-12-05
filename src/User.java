package src;

public abstract class User {

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
        String password
    ) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.username = username;
        this.age = age;
        this.height = height;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void print() {
        System.out.println("-------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Username: " + username);
    }

    public abstract void printInfo();
}
