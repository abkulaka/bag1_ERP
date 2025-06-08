package com.lab5;



import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {

    private List<Salary> salaries = new ArrayList<>();

    public Salary generateSalary(Employee employee, Bonus bonus, Deduction deduction, Attendance attendance) {
        double baseSalary = employee.getSalary();
        double bonusAmount = bonus != null ? bonus.getAmount() : 0;
        double deductionAmount = deduction != null ? deduction.getAmount() : 0;
        int daysPresent = attendance != null ? attendance.getDaysPresent() : 0;

        // Simple salary calculation:
        double netSalary = baseSalary + bonusAmount - deductionAmount;

        // If attendance affects salary, adjust here (optional)
        // e.g. netSalary *= (daysPresent / 22.0);

        Salary salary = new Salary(employee, netSalary);
        salaries.add(salary);
        return salary;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }
}
