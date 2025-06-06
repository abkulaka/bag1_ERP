package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SalaryTest {

    @Test
    public void testCalculateNetSalary_withSampleData() {
        Salary emp = new Salary("Bat", "Programmer", 1200000);

        int workedDays = 20;
        int absentDays = 2;
        int lateHours = 3;
        int overtimeHours = 5;
        double companyFee = 50000;
        double penaltyDollar = 10;

        int workDaysInMonth = 22;
        int workHoursInDay = 8;
        double overtimeMultiplier = 1.5;

        double dailySalary = emp.getBaseSalary() / workDaysInMonth;
        double hourlySalary = dailySalary / workHoursInDay;

        double absentDeduction = absentDays * dailySalary;
        double latePenalty = lateHours * hourlySalary;
        double overtimePay = overtimeHours * hourlySalary * overtimeMultiplier;
        double penaltyTugrik = penaltyDollar * 3000;

        double grossSalary = emp.getBaseSalary() + overtimePay - absentDeduction - latePenalty;
        double socialInsurance = grossSalary * 0.115;
        double healthInsurance = grossSalary * 0.05;

        double expected = grossSalary - companyFee - penaltyTugrik - socialInsurance - healthInsurance;

        double actual = emp.calculateNetSalary(
            workedDays, absentDays, lateHours, overtimeHours,
            companyFee, penaltyDollar,
            workDaysInMonth, workHoursInDay, overtimeMultiplier
        );

        assertEquals(expected, actual, 0.01);
    }
}
