import java.io.*;
import java.util.Scanner;

public class AddEmployee {

    public static void addEmployee(Scanner scanner) {
        System.out.print("OVOG, NER: ");
        String name = scanner.nextLine();

        System.out.print("TUGAAR: ");
        String tugaar = scanner.nextLine();

        System.out.print("EMAIL: ");
        String email = scanner.nextLine();

        System.out.print("ALBAN TUSHAAL: ");
        String position = scanner.nextLine();

        System.out.print("REGESTERIIN TUGAAR: ");
        String id = scanner.nextLine();

        System.out.print("MEREGJIL: ");
        String profession = scanner.nextLine();

        System.out.print("TSALIN: ");
        String salary = scanner.nextLine();

        System.out.print("AJIL EHLEH OGNOO: ");
        String startDate = scanner.nextLine();

        String folderName = "as";
        String filePrefix = "emp_it";
        String fileExtension = ".txt";

        String content = """
                Овог, нэр: %s
                Дугаар: %s
                Емайл: %s
                Албан тушаал: %s
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
                System.out.println("HADGALSAN: " + file.getAbsolutePath());
            }

        } catch (IOException e) {
            System.err.println("Алдаа: " + e.getMessage());
        }
    }
}
