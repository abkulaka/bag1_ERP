import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDataReader {

    public static class EmployeeInfo {
        public String fullName;
        public String phoneNumber;
        public String email;
        public String position;
        public String idNumber;
        public String profession;
        public double baseSalary;
        public LocalDate startDate;
    }

    public static EmployeeInfo readEmployeeInfo(File file) {
        EmployeeInfo emp = new EmployeeInfo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("Овог, нэр:")) {
                    emp.fullName = line.substring("Овог, нэр:".length()).trim();
                } else if (line.startsWith("Дугаар:")) {
                    emp.phoneNumber = line.substring("Дугаар:".length()).trim();
                } else if (line.startsWith("Емайл:")) {
                    emp.email = line.substring("Емайл:".length()).trim();
                } else if (line.startsWith("Албан тушаал:")) {
                    emp.position = line.substring("Албан тушаал:".length()).trim();
                } else if (line.startsWith("Иргэний үнэмлэх, регистрийн дугаар:")) {
                    emp.idNumber = line.substring("Иргэний үнэмлэх, регистрийн дугаар:".length()).trim();
                } else if (line.startsWith("Мэргэжил (ажлын төрлөөр):")) {
                    emp.profession = line.substring("Мэргэжил (ажлын төрлөөр):".length()).trim();
                } else if (line.startsWith("Цалингийн үндсэн хэмжээ:")) {
                    String salaryText = line.substring("Цалингийн үндсэн хэмжээ:".length()).trim().replace(",", "");
                    emp.baseSalary = Double.parseDouble(salaryText);
                } else if (line.startsWith("Ажлын эхлэх огноо:")) {
                    String dateText = line.substring("Ажлын эхлэх огноо:".length()).trim();
                    try {
                        emp.startDate = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (Exception e) {
                        emp.startDate = LocalDate.parse(dateText); // fallback if yyyy-MM-dd is default
                    }
                }
            }

            return emp;

        } catch (IOException e) {
            System.err.println("Файлыг уншихад алдаа гарлаа: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Цалинг хөрвүүлэхэд алдаа гарлаа: " + e.getMessage());
        }

        return null;
    }
}
