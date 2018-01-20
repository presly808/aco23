package company.model;


import company.utils.MyUtils;

public class Employee {

    private final int id;
    private String name;
    private int salary;

    public Employee() {
        this.id = MyUtils.genId();
    }

    public Employee(String name, int salary) {
        this.id = MyUtils.genId();
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
