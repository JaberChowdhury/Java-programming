class Vehicle {

    void drive() {
        System.out.println("drive bro");
    }
}

class Car extends Vehicle {

    void drive() {
        System.out.println("Repairing car");
    }
}

public class Inheritance {

    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
    }
}
