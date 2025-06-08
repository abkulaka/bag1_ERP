package com.lab5;


public class Employee {
    private int id;
    private String name;
    private double salary;
    private Contract contract;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Optional constructor if you want one without id
    public Employee(String name, double salary) {
        this(0, name, salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }
}
