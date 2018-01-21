package company.model;


import company.utils.MyUtils;

import java.util.List;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(String name, int salary) {
        this.id = MyUtils.genId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int setSalary(int salary) {
        return salary;
    }

    public int calculateSalary(Employee employee){
        return employee.getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
