package com.lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class CombinedClassTests {
    // Employee Tests
    @Test
    public void testEmployeeCreation() {
        Employee emp = new Employee(101, "John Smith", 75000.0);
        assertEquals(101, emp.getId());
        assertEquals("John Smith", emp.getName());
        assertEquals(75000.0, emp.getSalary(), 0.001);
    }

    @Test
    public void testEmployeeAlternateConstructor() {
        Employee emp = new Employee("Jane Doe", 80000.0);
        assertEquals(0, emp.getId()); // Default ID
        assertEquals("Jane Doe", emp.getName());
        assertEquals(80000.0, emp.getSalary(), 0.001);
    }

    @Test
    public void testEmployeeContractManagement() {
        Employee emp = new Employee(102, "Bob Johnson", 65000.0);
        Contract contract = new Contract("Full-time with benefits");
        
        emp.setContract(contract);
        assertNotNull(emp.getContract());
        assertEquals("Full-time with benefits", emp.getContract().getDetails());
    }

    // Salary Tests
    @Test
    public void testSalaryCreation() {
        Employee emp = new Employee(103, "Alice Brown", 70000.0);
        Salary salary = new Salary(emp, 65000.0);
        
        assertEquals(emp, salary.getEmployee());
        assertEquals(65000.0, salary.getNetSalary(), 0.001);
    }

    // Bonus Tests
    @Test
    public void testBonusCreation() {
        Bonus bonus = new Bonus(5000.0);
        assertEquals(5000.0, bonus.getAmount(), 0.001);
    }

    @Test
    public void testZeroBonus() {
        Bonus bonus = new Bonus(0.0);
        assertEquals(0.0, bonus.getAmount(), 0.001);
    }

    // Contract Tests
    @Test
    public void testContractCreation() {
        Contract contract = new Contract("Part-time temporary");
        assertEquals("Part-time temporary", contract.getDetails());
    }

    @Test
    public void testEmptyContractDetails() {
        Contract contract = new Contract("");
        assertEquals("", contract.getDetails());
    }

    // Deduction Tests
    @Test
    public void testDeductionCreation() {
        Deduction deduction = new Deduction(1200.0);
        assertEquals(1200.0, deduction.getAmount(), 0.001);
    }

    @Test
    public void testNegativeDeduction() {
        Deduction deduction = new Deduction(-500.0);
        assertEquals(-500.0, deduction.getAmount(), 0.001);
    }

    // Integration Tests
    @Test
    public void testEmployeeSalaryWithContract() {
        Employee emp = new Employee(104, "Charlie Davis", 90000.0);
        Contract contract = new Contract("Executive package");
        emp.setContract(contract);
        
        Salary salary = new Salary(emp, 85000.0);
        
        assertEquals(emp, salary.getEmployee());
        assertEquals("Executive package", emp.getContract().getDetails());
        assertEquals(85000.0, salary.getNetSalary(), 0.001);
    }

    @Test
    public void testCompleteCompensationPackage() {
        // Create employee
        Employee emp = new Employee(105, "Eva Green", 100000.0);
        
        // Add contract
        emp.setContract(new Contract("Senior management"));
        
        // Create salary with deductions and bonus
        Salary salary = new Salary(emp, 95000.0);
        Bonus bonus = new Bonus(15000.0);
        Deduction deduction = new Deduction(5000.0);
        
        // Verify all components
        assertEquals(100000.0, emp.getSalary(), 0.001);
        assertEquals("Senior management", emp.getContract().getDetails());
        assertEquals(95000.0, salary.getNetSalary(), 0.001);
        assertEquals(15000.0, bonus.getAmount(), 0.001);
        assertEquals(5000.0, deduction.getAmount(), 0.001);
    }
}