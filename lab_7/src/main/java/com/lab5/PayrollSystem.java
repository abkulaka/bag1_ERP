package com.lab5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private static final Logger logger = LogManager.getLogger(PayrollSystem.class);
    private List<Salary> salaries = new ArrayList<>();

    public Salary generateSalary(Employee employee, Bonus bonus, Deduction deduction, Attendance attendance) {
        double baseSalary = employee.getSalary();
        double bonusAmount = bonus != null ? bonus.getAmount() : 0;
        double deductionAmount = deduction != null ? deduction.getAmount() : 0;
        int daysPresent = attendance != null ? attendance.getDaysPresent() : 0;

        double netSalary = baseSalary + bonusAmount - deductionAmount;

        logger.info("Цалинг тооцлоо: {} - Цэвэр цалин: {}", employee.getName(), netSalary);

        if (attendance != null && !attendance.isPresent(employee)) {
            logger.warn("Анхаар: {} ажилд ирээгүй байж болзошгүй", employee.getName());
        }

        Salary salary = new Salary(employee, netSalary);
        salaries.add(salary);
        return salary;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }
}
