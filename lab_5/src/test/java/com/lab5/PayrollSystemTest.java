package com.lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PayrollSystemTest {

@Test
public void testCalculateSalaryAndAttendance() {
    Employee employee = new Employee(1, "John", 1000.0);

    Bonus bonus = new Bonus(200.0);
    Deduction deduction = new Deduction(100.0);
    Attendance attendance = new Attendance(20);
    attendance.markPresent(employee);

    PayrollSystem payroll = new PayrollSystem();
    Salary salary = payroll.generateSalary(employee, bonus, deduction, attendance);

    // Шалгалт: 1000 + 200 - 100 = 1100
    assertEquals(1100.0, salary.getNetSalary(), 0.01);

    // Attendance test
    assertTrue(attendance.isPresent(employee));
}

}
