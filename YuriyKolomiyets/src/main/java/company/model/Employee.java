package company.model;

import company.utils.MyUtils;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Worker, Comparator<Employee> {


    private int id;
    private String name;
    private int salary;
    private GregorianCalendar birthday;
    private Date startWorkDate;
    private Date endWorkDate;

    public Employee() {
        this.id = MyUtils.genId();
    }

    public Employee(String name, int salary) {
        this.id = MyUtils.genId();
        this.name = name;
        this.salary = salary;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return
                "name " + name + '\'' +
                ", salary " + salary;
    }

    @Override
    public int compare(Employee employee1, Employee employee2) {
        if(employee1.getSalary()> employee2.getSalary()) {
            return 1;
        } else if (employee1.getSalary()< employee2.getSalary()){
            return -1;
        } else {
            return 0;
        }
    }
}

