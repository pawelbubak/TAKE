package ai.faces.model;

public class Student {
    private String name;
    private String surname;
    private double average;

    public Student() {
    }

    public Student(String name, String surname, double average) {
        this.name = name;
        this.surname = surname;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
