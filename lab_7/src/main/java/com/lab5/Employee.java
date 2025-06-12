package com.lab5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private Contract contract;

    private static final Logger logger = Logger.getLogger("employee.log");

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

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

    public void addEmployee(Scanner scanner) {
        try {
            System.out.print("Ажилтны ID: ");
            this.id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ажилтны нэр: ");
            this.name = scanner.nextLine();

            System.out.print("Цалин: ");
            this.salary = Double.parseDouble(scanner.nextLine());

           
            String fileName = "emp_" + id + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write("ID: " + id + "\n");
            writer.write("Нэр: " + name + "\n");
            writer.write("Цалин: " + salary + "\n");
            writer.close();

            logger.info("Ажилтны мэдээлэл амжилттай хадгалагдлаа: ID = " + id);

            System.out.println("Ажилтны мэдээлэл амжилттай нэмэгдлээ!");
        } catch (IOException | NumberFormatException e) {
            logger.severe("Алдаа гарлаа: " + e.getMessage());
            System.err.println("Алдаа: " + e.getMessage());
        }
    }
}
