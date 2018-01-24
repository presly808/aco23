package company.model;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    /**
     * You can add any additional classes to make structure more flexible and scalable
     */
        public final int COEFFICIENT = 20;

        private String name;
        private int salary;
        private List<Employee> workersList;

        public Manager() {
            this.workersList = new ArrayList<>();

        }

        public Manager(String name, int salary) {
            this.name = name;
            this.salary = salary;
            this.workersList = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return calculateSalary();
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public List<Employee> getWorkersList() {
            return workersList;
        }

        public void setWorkersList(List<Employee> workersList) {
            this.workersList = workersList;
        }

        // manager has fixed salary + 5% from each employee that subordinate to manager

        public int calculateSalary() {
            if (workersList.isEmpty()) {
                return salary;
            }
            for (Employee employee : workersList) {
                 salary += (employee.getSalary() / COEFFICIENT);
            }
            return salary;
        }

        public boolean addSubworker(Employee employee) {
            if (employee != null && workersList != null) {
                workersList.add(employee);
                return true;
            }
            return false;
        }

        public List<Employee> getSubworkers() {
            return workersList;
        }
}
