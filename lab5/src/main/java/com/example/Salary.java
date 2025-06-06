package com.example;

public class Salary {
    private String fullName;
    private String position;
    private double baseSalary;

    private static final double PENALTY_CONVERSION_RATE = 3000.0; // 1 USD = 3000 ₮

    public Salary(String fullName, String position, double baseSalary) {
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Сардаа гар дээр авах цалинг тооцно
     *
     * @param workedDays       Сардаа ажилласан өдөр
     * @param absentDays       Тасалсан өдөр
     * @param lateHours        Хоцорсон цаг
     * @param overtimeHours    Илүү цаг
     * @param companyFee       Байгууллагын шимтгэл (₮)
     * @param penalty          Торгууль ($)
     * @param standardWorkDays Нэг сард ажиллах ёстой нийт өдөр (ихэвчлэн 22)
     * @param dailyHours       Нэг өдрийн ажлын цаг (ихэвчлэн 8)
     * @param overtimeRate     Илүү цагийн нэмэгдэл (ихэвчлэн 1.5)
     * @return Гар дээр авах цалин (₮)
     */
    public double calculateNetSalary(
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
        // Avoid division by zero
        if (standardWorkDays <= 0 || dailyHours <= 0) {
            throw new IllegalArgumentException("standardWorkDays and dailyHours must be greater than 0");
        }

        double dailySalary = baseSalary / standardWorkDays;
        double hourlySalary = dailySalary / dailyHours;

        double absentDeduction = absentDays * dailySalary;
        double lateDeduction = lateHours * hourlySalary;
        double overtimeBonus = overtimeHours * hourlySalary * overtimeRate;

        // Convert penalty from $ to ₮
        double penaltyTugrik = penalty * PENALTY_CONVERSION_RATE;

        double grossSalary = baseSalary + overtimeBonus - absentDeduction - lateDeduction;

        double socialInsurance = grossSalary * 0.115;  // 11.5%
        double healthInsurance = grossSalary * 0.05;   // 5%

        double netSalary = grossSalary - companyFee - penaltyTugrik - socialInsurance - healthInsurance;

        if (netSalary < 0) netSalary = 0;

        return netSalary;
    }
}
