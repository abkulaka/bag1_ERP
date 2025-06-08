import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();
    private List<Salary> salaries = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int id) {
        Employee found = null;
        for (Employee e : employees) {
            if (e.getId() == id) {
                found = e;
                break;
            }
        }
        if (found != null) {
            employees.remove(found);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void listEmployees() {
        System.out.println("\n--- Employee List ---");
        for (Employee e : employees) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName());
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public void generateSalary(Employee e, Bonus b, Deduction d, Attendance a) {
        double base = e.getContract().getBaseSalary();
        double bonus = b.getAmount();
        double deduction = d.getAmount();
        double penalty = (a.getLateHours() * 1000) + (a.getAbsentDays() * 20000);
        double total = base + bonus - deduction - penalty;
        salaries.add(new Salary(e, total));
        System.out.println("Salary generated: ₮" + total);
    }

    public void showSalaryList() {
        System.out.println("\n--- Salary List ---");
        for (Salary s : salaries) {
            System.out.println("ID: " + s.getEmployee().getId() +
                    " | Name: " + s.getEmployee().getName() +
                    " | Total: ₮" + s.getTotal() +
                    " | Paid: " + (s.isPaid() ? "Yes" : "No"));
        }
    }
}
