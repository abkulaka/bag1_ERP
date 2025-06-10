package com.lab5;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Нэр хоосон байж болохгүй");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Цалин сөрөг утгатай байж болохгүй");
        }
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}
