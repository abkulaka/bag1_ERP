package com.lab5;


public class Salary {
    private Employee employee;
    private double netSalary;

    public Salary(Employee employee, double netSalary) {
        this.employee = employee;
        this.netSalary = netSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
