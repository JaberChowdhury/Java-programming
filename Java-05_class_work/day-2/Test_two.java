class Employee {

    String name, address, job_title;
    Float salary;

    Employee(String name, String address, String job_title, Float salary) {
        this.name = name;
        this.address = address;
        this.job_title = job_title;
        this.salary = salary;
    }

    void performance_report() {
        System.out.println("You rock bro!! with 30 days streak");
    }

    void calculate_bonuses() {
        Float bonus = salary + (salary * (30 / 100));
        System.out.println("salary bonus for " + job_title + " is " + bonus);
    }

    void generate_report() {
        System.out.println("You are good bro");
    }
}

class Manager extends Employee {

    Manager(String name, String address, String job_title, Float salary) {
        super(name, address, job_title, salary);
    }

    void calculate_bonuses() {
        float bonus = salary + (salary * 0.3f);
        System.out.println("salary bonus for " + job_title + " is " + bonus);
    }

    void manage_project() {
        System.out.println(
            "Project is done bro\n I am 10x engineer after all !!"
        );
    }
}

class Developer extends Employee {

    Developer(String name, String address, String job_title, Float salary) {
        super(name, address, job_title, salary);
    }

    void calculate_bonuses() {
        float bonus = salary + (salary * 0.2f);
        System.out.println("salary bonus for " + job_title + " is " + bonus);
    }
}

class Programmer extends Employee {

    Programmer(String name, String address, String job_title, Float salary) {
        super(name, address, job_title, salary);
    }

    void calculate_bonuses() {
        float bonus = salary + (salary * 0.1f);
        System.out.println("salary bonus for " + job_title + " is " + bonus);
    }
}

class Test_two {

    public static void main(String[] args) {
        Manager m = new Manager("Jaber", "Dhaka uddan", "Manager", 12000f);
        Developer d = new Developer(
            "Anas",
            "Dhaka Mirpur",
            "Developer",
            10000f
        );
        Programmer p = new Programmer("Masum", "Cumilla", "Programmer", 8000f);

        m.calculate_bonuses();
        m.manage_project();
        m.performance_report();
        d.calculate_bonuses();
        d.performance_report();
        p.calculate_bonuses();
        p.performance_report();
    }
}
