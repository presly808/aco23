package week2;

import java.util.LinkedList;
import java.util.List;

public class Manager implements Worker {

    private String name;
    private int salary;
    private List<Worker> workers;
    private final double COEFICIENT = 0.05;


    Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        workers = new LinkedList<>();
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
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
        return worker != null && workers.add(worker);
    }

    public List<Worker> getSubworkers() {
        return workers;
    }
}
