package week2;

import java.util.LinkedList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager implements Worker {

    private String name;
    private int salary;
    private List<Worker> workers;

    public Manager() {
        workers = new LinkedList<>();
    }

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.workers = new LinkedList<>();
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
        return workers;
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    @Override
    public int calculateSalary(){
        int resultSalary = salary
        for (Worker worker : workers) {
            resultSalary += worker.calculateSalary() / 20;
        }
        return resultSalary;
    }

    public boolean addSubworker(Worker employee) {
        if(employee != null) {
            workers.add(employee);
            return true;
        }
        return false;
    }

    public List<Worker> getSubworkers(){
        return workers;
    }


}