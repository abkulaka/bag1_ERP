import java.io.File;
import java.util.Scanner;

public class EmployeeFileDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ustgah ajilchnii meteelel: ");
        String fileName = "emp_it"+scanner.nextLine()+".txt";
        
        String folderName = "as";
        File file = new File(folderName, fileName);
        
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + " ustgasan");
            } else {
                System.out.println(fileName + " errr");
            }
        } else {
            System.out.println(fileName + " olsongui");
        }
        
        scanner.close();
    }
}
