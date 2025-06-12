package com.lab5;

import java.util.HashSet;
import java.util.Set;

public class Attendance {
    private int daysPresent;
    private Set<Employee> presentEmployees = new HashSet<>();

    public Attendance(int daysPresent) {
        this.daysPresent = daysPresent;
    }

    public int getDaysPresent() {
        return daysPresent;
    }

    public void markPresent(Employee emp) {
        presentEmployees.add(emp);
    }

    public boolean isPresent(Employee emp) {
        return presentEmployees.contains(emp);
    }
}
