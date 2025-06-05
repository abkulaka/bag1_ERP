import java.time.LocalDate;

public class Salary {

    public static double calculateNetSalary(
            String fullName,
            String position,
            double baseSalary,
            LocalDate startDate,
            int workedDays,
            int absentDays,
            int lateHours,
            int overtimeHours,
            double companyFee,
            double penalty,
            int standardWorkDays,
            int dailyHours,
            double overtimeRate
    ) {
        // Нэг өдрийн цалин
        double dailySalary = baseSalary / standardWorkDays;

        // Нэг цагийн цалин
        double hourlySalary = dailySalary / dailyHours;

        // Тасалсан өдрүүдийн хасалт
        double absentDeduction = absentDays * dailySalary;

        // Хоцорсон цагийн хасалт
        double lateDeduction = lateHours * hourlySalary;

        // Илүү цагийн нэмэгдэл
        double overtimeBonus = overtimeHours * hourlySalary * overtimeRate;

        // Нийт цалин: үндсэн + илүү цаг - тасалсан - хоцорсон - шимтгэл - торгууль
        double netSalary = baseSalary + overtimeBonus - absentDeduction - lateDeduction - companyFee - penalty;

        // Цалинг 0-оос доош унахгүй байх
        if (netSalary < 0) {
            netSalary = 0;
        }

        return netSalary;
    }
}
