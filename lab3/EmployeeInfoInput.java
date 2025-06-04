import java.io.*;
import java.util.Scanner;

public class EmployeeInfoInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ovog,ner: ");
        String name = scanner.nextLine();

        System.out.print("tugaar: ");
        String tugaar = scanner.nextLine();

        System.out.print("email: ");
        String email = scanner.nextLine();

        System.out.print("Alban tushaal: ");
        String position = scanner.nextLine();

        System.out.print("reg tugar: ");
        String id = scanner.nextLine();

        System.out.print("meregjil: ");
        String profession = scanner.nextLine();

        System.out.print("tsalin: ");
        String salary = scanner.nextLine();

        System.out.print("ajliin ehelsen ognoo: ");
        String startDate = scanner.nextLine();

        String folderName = "as";
        String filePrefix = "emp_it";
        String fileExtension = ".txt";

        String content = """
                Овог, нэр: %s
                Дугаар: %s
                Емайл: %s
                Албан тушаал %s
                Иргэний үнэмлэх, регистрийн дугаар: %s
                Мэргэжил (ажлын төрлөөр): %s
                Цалингийн үндсэн хэмжээ: %s
                Ажлын эхлэх огноо: %s
                """.formatted(name, tugaar, email, position, id, profession, salary, startDate);

        try {
            File directory = new File(folderName);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            int fileNumber = 1;
            File file;
            do {
                String fileName = filePrefix + fileNumber + fileExtension;
                file = new File(directory, fileName);
                fileNumber++;
            } while (file.exists());

            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
                writer.write(content);
                System.out.println("Hatgalsan: " + file.getAbsolutePath());
            }

        } catch (IOException e) {
            System.err.println("errrr: " + e.getMessage());
        }
    }
}
