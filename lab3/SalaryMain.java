import java.io.File;
import java.util.Scanner;

public class SalaryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File folder = new File("as");
        File[] files = folder.listFiles((dir, name) -> name.startsWith("emp_it") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("AJILTNII MEDDEE OLOLDSONGUI.");
            scanner.close();
            return;
        }

        System.out.println("\n--- AJILTAN SONGONO UU ---");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        System.out.print("SONGOLT: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("BURUU SONGOLT.");
            scanner.close();
            return;
        }

        if (choice < 1 || choice > files.length) {
            System.out.println("BURUU SONGOLT.");
            scanner.close();
            return;
        }

        File selectedFile = files[choice - 1];
        EmployeeDataReader.EmployeeInfo emp = EmployeeDataReader.readEmployeeInfo(selectedFile);

        if (emp == null) {
            System.out.println("AJILTNI MEDEELEL UNSHIJ CHADSANGUI.");
            scanner.close();
            return;
        }

        try {
            System.out.print("SARDA AJILLSAN UDUR: ");
            int workedDays = Integer.parseInt(scanner.nextLine());

            System.out.print("TASTSAN UDUR: ");
            int absentDays = Integer.parseInt(scanner.nextLine());

            System.out.print("HOTSOJ IRSEN TSAG: ");
            int lateHours = Integer.parseInt(scanner.nextLine());

            System.out.print("ILUU TSAGTAI YU? (tiim=1 / ugui=0): ");
            int hasOvertime = Integer.parseInt(scanner.nextLine());

            int overtimeHours = 0;
            if (hasOvertime == 1) {
                System.out.print("ILUU TSAGIIN TOO: ");
                overtimeHours = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("SHIMTGEL (₮): ");
            double companyFee = Double.parseDouble(scanner.nextLine());

            System.out.print("TOROL BUREES (₮): ");
            double penalty = Double.parseDouble(scanner.nextLine());

            double finalSalary = Salary.calculateNetSalary(
                    emp.fullName, emp.position, emp.baseSalary, emp.startDate,
                    workedDays, absentDays, lateHours, overtimeHours,
                    companyFee, penalty,
                    22, 8, 1.5
            );

            System.out.println("\n--- TSALINGIIN TAILAN ---");
            System.out.println("Ajiltan: " + emp.fullName);
            System.out.printf("Net tsalin: %.2f \n", finalSalary);

        } catch (NumberFormatException e) {
            System.out.println("Buruu oruulga baina. Too oruulna uu.");
        }

        scanner.close();
    }
}
