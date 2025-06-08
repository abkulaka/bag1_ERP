public class Salary {
    private Employee employee;
    private double total;
    private boolean paid;

    public Salary(Employee employee, double total) {
        this.employee = employee;
        this.total = total;
        this.paid = false;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
