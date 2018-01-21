package week2;

import java.util.LinkedList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager implements Worker {

    public final int COEFFICIENT = 20;

    private String name;
    private int salary;
    private List<Worker> workersList;

    public Manager() {
        workersList = new LinkedList<>();
    }

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.workersList = new LinkedList<>();
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

    // manager has fixed salary + 5% from each employee that subordinate to manager
    @Override
    public int calculateSalary(){
        int resultSalary = salary;

        for (Worker worker : workersList) {
            resultSalary += worker.calculateSalary() / COEFFICIENT;
        }

        return resultSalary;
    }

    public boolean addSubworker(Worker employee) {
        return employee != null && workersList.add(employee);
    }

    public List<Worker> getSubworkers(){
        return workersList;
    }


}
