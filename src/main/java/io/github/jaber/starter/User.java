package io.github.jaber.starter;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty age;
    private final SimpleDoubleProperty salary;
    private final SimpleBooleanProperty isActive; // This controls the checkbox

    public User(String name, int age, double salary, boolean isActive) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.salary = new SimpleDoubleProperty(salary);
        this.isActive = new SimpleBooleanProperty(isActive);
    }

    // Getters for PropertyValueFactory to find
    public String getName() {
        return name.get();
    }

    public int getAge() {
        return age.get();
    }

    public double getSalary() {
        return salary.get();
    }

    // Special getter for the Checkbox to work two-way
    public SimpleBooleanProperty isActiveProperty() {
        return isActive;
    }
}
