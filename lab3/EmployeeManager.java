import java.io.*;
import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1: Ажилтан нэмэх");
        System.out.println("2: Ажилтан устгах");
        System.out.print("Сонголт оруулна уу (1 эсвэл 2): ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                addEmployee(scanner);
                break;
            case "2":
                deleteEmployee(scanner);
                break;
            default:
                System.out.println("Буруу сонголт!");
        }

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Овог, нэр: ");
        String name = scanner.nextLine();

        System.out.print("Дугаар: ");
        String tugaar = scanner.nextLine();

        System.out.print("Емайл: ");
        String email = scanner.nextLine();

        System.out.print("Албан тушаал: ");
        String position = scanner.nextLine();

        System.out.print("Регистрийн дугаар: ");
        String id = scanner.nextLine();

        System.out.print("Мэргэжил: ");
        String profession = scanner.nextLine();

        System.out.print("Цалин: ");
        String salary = scanner.nextLine();

        System.out.print("Ажлын эхлэх огноо: ");
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
                System.out.println("Хадгалсан: " + file.getAbsolutePath());
            }

        } catch (IOException e) {
            System.err.println("Алдаа гарлаа: " + e.getMessage());
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Устгах ажилтны дугаар (жишээ нь 1): ");
        String number = scanner.nextLine();

        String folderName = "as";
        String fileName = "emp_it" + number + ".txt";
        File file = new File(folderName, fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + " файлыг амжилттай устгалаа.");
            } else {
                System.out.println(fileName + " файлыг устгаж чадсангүй.");
            }
        } else {
            System.out.println(fileName + " файл олдсонгүй.");
        }
    }
}
