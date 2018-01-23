package week2;

import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager {

    public final int COEFFICIENT = 20;

    private String name;
    private int salary;
    private List<Worker> workersList;

    public Manager() {
    }

    public Manager(String name, int salary, List<Worker> workersList) {
        this.name = name;
        this.salary = salary;
        this.workersList = workersList;
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

    public List<Worker> getWorkersList() {
        return workersList;
    }

    public void setWorkersList(List<Worker> workersList) {
        this.workersList = workersList;
    }


    // manager has fixed salary + 5% from each employee that subordinate to manager

    public int calculateSalary() {
        return 0;
    }

    public boolean addSubworker(Employee employee) {
        if (employee != null) {
            workersList.add(employee);
        }
        return false;
    }

    public List<Worker> getSubworkers() {
        return workersList;
    }
}
