package company.db;

import company.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class AppDb {

    private List<Employee> workersList;

    public AppDb() {
        this.workersList = new ArrayList<>();
    }

    public List<Employee> getWorkersList() {
        return workersList;
    }

    public void setWorkersList(List<Employee> workersList) {
        this.workersList = workersList;
    }

    public Employee add(Employee employee) {
        if (employee != null) {
            workersList.add(employee);
        }
        return null;
    }

    public List<Employee> getAll() {
        return workersList;
    }

}