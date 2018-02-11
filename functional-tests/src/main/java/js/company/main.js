function User(id,age,name,salary){

    // assign all input arguments to this

    // create method toString

    // calculate salary

}

function Manager(id,age,name,salary) {
    // add subworker
    // remove subworker
    // getAllSubworkers
    // calculate salary
}

function AppDb(users){
    //
}

// create app db and use it in the methods below
var appDB;


/*
    todo create the following function, they will be invoked from the java

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    int calculateSalary(Employee employee);

    int calculateSalaries();

    Employee getById(int id);

    List<Employee> findWithFilter(String name);

    List<Employee> filterWithPredicate(EmployeePredicate predicate, Comparator<Employee> comparator);

    Employee fireWorker(int workerId);

    Employee updateWorker(Employee worker);

    boolean areWorkersEqual(int emp1id, int eml2id);

*/

function addEmployee(employee){
    // add an employee to the db, that must have been initialized above
    print(employee['id'])
    print(employee['salary'])
    print(employee['name'])
    employee['id'] = 23;

    return employee
}

function testFunction(fun){
    // add an employee to the db, that must have been initialized above
    print(fun(23))
}


function testBiFunction(fun){
    // add an employee to the db, that must have been initialized above
    print(fun(23,23))
}