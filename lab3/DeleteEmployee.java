import java.io.File;
import java.util.Scanner;

public class DeleteEmployee {

    public static void deleteEmployee(Scanner scanner) {
        System.out.print("USTGAH AJILTNII IT: ");
        String number = scanner.nextLine();

        String folderName = "as";
        String fileName = "emp_it" + number + ".txt";
        File file = new File(folderName, fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + " AMJILTTAY USTGAGDLAA.");
            } else {
                System.out.println(fileName + " USTGAHAD ALDAA GARCH BAINA.");
            }
        } else {
            System.out.println(fileName + " OLDSONGUI.");
        }
    }
}
