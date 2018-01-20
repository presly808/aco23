package company.model;


import company.utils.MyUtils;

public class Employee {

    private int id;
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.id = MyUtils.genId();
    }

    public int getId() {
        return id;
    }
}
