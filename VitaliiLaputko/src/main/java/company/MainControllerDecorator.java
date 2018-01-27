package company;

import company.controller.MainController;
import company.controller.MainControllerImpl;
import company.db.AppDb;
import company.model.Employee;
import company.utils.filtering.EmployeePredicate;

import java.util.Comparator;
import java.util.List;

public class MainControllerDecorator {

    MainController mainController = new MainControllerImpl(new AppDb());

    public MainControllerDecorator() {
    }

    private Object timeCount(MyAction action){
        long startTime = System.currentTimeMillis();
        // start
        Object ret = action.action();
        // end
        long endTime = System.currentTimeMillis();

        System.out.println("Add employee took " + (endTime - startTime) + " milliseconds");
        return ret;
    }

    public Employee addEmployee(Employee employee){
        return (Employee) timeCount(() -> mainController.addEmployee(employee));
    }

    public List<Employee> getAllEmployees(){
        return (List<Employee>) timeCount(mainController::getAllEmployees);
    }

    public int calculateSalary(Employee employee) {
        return (int) timeCount(() -> mainController.calculateSalary(employee));
    }

    public int calculateSalaries() {
        return (int) timeCount(() -> mainController.calculateSalaries());
    }

    public Employee getById(int id) {
        return (Employee) timeCount(() -> mainController.getById(id));
    }

    public List<Employee> findWithFilter(String name) {
        return (List<Employee>) timeCount(() -> mainController.findWithFilter(name));
    }

    public List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator) {
        return (List<Employee>) timeCount(() -> mainController.filterWithPredicate(predicate, comparator));
    }

    public Employee fireWorker(int workerId) {
        return (Employee) timeCount(() -> mainController.fireWorker(workerId));
    }

    public Employee updateWorker(Employee worker) {
        return (Employee) timeCount(() -> mainController.updateWorker(worker));
    }

    public boolean areWorkersEqual(int emp1id, int eml2id) {
        return (boolean) timeCount(() -> mainController.areWorkersEqual(emp1id, eml2id));
    }
}
