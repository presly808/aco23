package week2;


public class Employee implements Worker {

    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }
}