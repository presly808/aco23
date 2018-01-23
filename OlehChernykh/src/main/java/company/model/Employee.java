package company.model;


import company.utils.MyUtils;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

    private final int id;
    private String name;
    private int salary;
    private GregorianCalendar birthday;
    private Date startWorkDate;
    private Date endWorkDate;


    public Employee(String name, int salary) {
        this.id = MyUtils.genId();
        this.name = name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public int getId() {
        return id;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    public int calculatesalary(){
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return id == employee.id;
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
