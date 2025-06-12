package com.lab5;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayrollSystem {
    private static final Logger logger = LogManager.getLogger(PayrollSystem.class);
    private List<Salary> salaries = new ArrayList<>();

    public Salary generateSalary(Employee employee, Bonus bonus, Deduction deduction, Attendance attendance) {
        if (employee == null) {
            logger.error("Employee cannot be null");
            throw new IllegalArgumentException("Employee cannot be null");
        }

        double baseSalary = employee.getSalary();
        double bonusAmount = bonus != null ? bonus.getAmount() : 0;
        double deductionAmount = deduction != null ? deduction.getAmount() : 0;
        int daysPresent = attendance != null ? attendance.getDaysPresent() : 0;

        double netSalary = baseSalary + bonusAmount - deductionAmount;

        logger.info("Calculating salary: {} - Net salary: {}", employee.getName(), netSalary);

        if (attendance != null && !attendance.isPresent(employee)) {
            logger.warn("Warning: {} might be absent from work", employee.getName());
        }

        Salary salary = new Salary(employee, netSalary);
        salaries.add(salary);
        return salary;
    }

    public List<Salary> getSalaries() {
        return new ArrayList<>(salaries); // Return a copy to maintain encapsulation
    }
}