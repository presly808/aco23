package company.model;


import company.utils.MyUtils;

public class Employee {

    private int id;
    private String name;
    private int salary;

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

    public int getSalary() {
        return salary;
    }
}
