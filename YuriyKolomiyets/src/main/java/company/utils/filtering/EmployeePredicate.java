package company.utils.filtering;

import company.model.Employee;

public interface EmployeePredicate {

    boolean filter(Employee employee);

}
