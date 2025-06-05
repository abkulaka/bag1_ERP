import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== AJILTANTAI HOLBOOTTOI SYSTEM ===");
            System.out.println("1. Ajiltan nemeh");
            System.out.println("2. Ajiltan ustgah");
            System.out.println("3. Tsalin bodoh");
            System.out.println("4. Garah");
            System.out.print("Songoltoo oruul: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Buruu utga! Dahiad orolddono uu.");
                continue;
            }

            switch (choice) {
                case 1:
                    AddEmployee.addEmployee(scanner);
                    break;
                case 2:
                    DeleteEmployee.deleteEmployee(scanner);
                    break;
                case 3:
                    SalaryMain.main(null);
                    break;
                case 4:
                    exit = true;
                    System.out.println("GARCH BAINA...");
                    break;
                default:
                    System.out.println("Buruu songolt. Dahiad oruulna uu.");
            }
        }

        scanner.close();
    }
}
