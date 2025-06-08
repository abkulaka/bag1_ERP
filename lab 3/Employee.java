public class Employee {
    private static int counter = 1;
    private int id;
    private String name;
    private Contract contract;

    public Employee(String name) {
        this.id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
    }
}
