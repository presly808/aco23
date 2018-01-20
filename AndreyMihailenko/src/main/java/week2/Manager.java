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
    public final double COEFICIENT = 0.05;


    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        workers = new LinkedList<>();
    }

    public int getSalary() {
        return salary;
    }


    // manager has fixed salary + 5% from each employee that subordinate to manager
    public int calculateSalary() {
        int allSalary = salary;
        for (Worker worker : workers) {
            allSalary += worker.getSalary() * COEFICIENT;
        }
        return allSalary;
    }

    public boolean addSubworker(Worker worker) {
        if (worker == null) {
            return false;
        }
        return workers.add(worker);
    }

    public List<Worker> getSubworkers() {
        return workers;
    }
}
