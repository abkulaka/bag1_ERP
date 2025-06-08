import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem system = new PayrollSystem();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- TSALINGIIN SYSTEM ---");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. Show employee list");
            System.out.println("4. Generate salary");
            System.out.println("5. Show salary list");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Base salary: ");
                    double baseSalary = sc.nextDouble();
                    Employee emp = new Employee(name);
                    emp.setContract(new Contract(baseSalary));
                    system.addEmployee(emp);
                    break;

                case 2:
                    System.out.print("Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    system.removeEmployee(removeId);
                    break;

                case 3:
                    system.listEmployees();
                    break;

                case 4:
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    Employee selected = system.findEmployeeById(id);
                    if (selected == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    System.out.print("Bonus amount ₮: ");
                    double bonusAmt = sc.nextDouble();
                    System.out.print("Deduction amount ₮: ");
                    double dedAmt = sc.nextDouble();
                    System.out.print("Late hours: ");
                    int late = sc.nextInt();
                    System.out.print("Absent days: ");
                    int absent = sc.nextInt();

                    Bonus bonus = new Bonus(bonusAmt);
                    Deduction deduction = new Deduction(dedAmt);
                    Attendance att = new Attendance(late, absent);

                    system.generateSalary(selected, bonus, deduction, att);
                    break;

                case 5:
                    system.showSalaryList();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
