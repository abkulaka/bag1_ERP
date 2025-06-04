import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class SalaryFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File folder = new File("as");
        File[] files = folder.listFiles((dir, name) -> name.startsWith("emp_it") && name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Ажилтны мэдээлэл хадгалагдсан файл олдсонгүй.");
            return;
        }

        // Файл сонгох
        System.out.println("songo:");
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + files[i].getName());
        }

        System.out.print("it oruul: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > files.length) {
            System.out.println("errr.");
            return;
        }

        File selectedFile = files[choice - 1];

        String fullName = "", position = "", startDateStr = "";
        double baseSalary = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Овог, нэр:")) {
                    fullName = line.substring(10).trim();
                } else if (line.startsWith("Албан тушаал")) {
                    position = line.substring(14).trim();
                } else if (line.startsWith("Цалингийн үндсэн хэмжээ:")) {
                    baseSalary = Double.parseDouble(line.substring(26).trim());
                } else if (line.startsWith("Ажлын эхлэх огноо:")) {
                    startDateStr = line.substring(20).trim();
                }
            }
        } catch (IOException e) {
            System.err.println("err ret: " + e.getMessage());
            return;
        }

        LocalDate hireDate = LocalDate.parse(startDateStr);

        // Ажилласан мэдээлэл
        System.out.print("sart ajilsan utur: ");
        int workedDays = scanner.nextInt();

        System.out.print("tasalsan utur: ");
        int absentDays = scanner.nextInt();

        System.out.print("hotsorson tsag: ");
        int lateHours = scanner.nextInt();

        System.out.print("iluu ajilsan uu? (tiim=1 / ugui=0): ");
        int hasOvertime = scanner.nextInt();
        int overtimeHours = 0;
        if (hasOvertime == 1) {
            System.out.print("iluu tsagiin too: ");
            overtimeHours = scanner.nextInt();
        }

        System.out.print("shimtgrl comp (₮): ");
        double companyFee = scanner.nextDouble();

        System.out.print("fee (₮): ");
        double penalty = scanner.nextDouble();

        double finalSalary = calculateNetSalary(
                fullName, position, baseSalary, hireDate, workedDays, absentDays,
                lateHours, overtimeHours, companyFee, penalty,
                22, 8, 1.5);

        System.out.println("\n--- tsalin ---");
        System.out.println("ajiltan: " + fullName + ", alban tushaaal: " + position);
        System.out.printf("tsalin: %.2f ₮\n", finalSalary);
    }

    public static double calculateNetSalary(String fullName, String position, double baseSalary, LocalDate hireDate,
                                            int workedDays, int absentDays, int lateHours, int overtimeHours,
                                            double companyFee, double penalty,
                                            int workDaysPerMonth, int hoursPerDay, double overtimeBonusRate) {

        // Шимтгэлийн хувь
        final double SOCIAL_INSURANCE_RATE = 0.10; // Нийгмийн даатгал
        final double HEALTH_INSURANCE_RATE = 0.05; // Эрүүл мэндийн даатгал

        double dailySalary = baseSalary / workDaysPerMonth;
        double hourlySalary = dailySalary / hoursPerDay;

        double regularSalary = workedDays * dailySalary;
        double lateDeduction = lateHours * hourlySalary * 0.5;
        double absentDeduction = absentDays * dailySalary;
        double overtimeBonus = overtimeHours * hourlySalary * overtimeBonusRate;

        // Нийгмийн болон эрүүл мэндийн даатгалын шимтгэл
        double socialInsurance = baseSalary * SOCIAL_INSURANCE_RATE;
        double healthInsurance = baseSalary * HEALTH_INSURANCE_RATE;

        // Нийт цалин
        double netSalary = regularSalary
                - lateDeduction
                - absentDeduction
                - socialInsurance
                - healthInsurance
                - companyFee
                - penalty
                + overtimeBonus;

        return Math.max(netSalary, 0); // Сөрөг цалин үүсэхээс сэргийлэх
    }
}
