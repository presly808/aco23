package company.utils.filtering;

import company.model.Employee;

public class EmployeePredicateImpl implements EmployeePredicate {

    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() < 3000;
    }
}
