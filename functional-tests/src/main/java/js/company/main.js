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

function Service(db){

    this.appDB = db;

    this.addEmployee = function(employee){

    }

    this.getAllEmployees = function(){

    }

    this.calculateSalary = function(employee){

    }

    this.calculateSalaries = function(){

    }

    this.getById = function(id){

    }

    this.findWithFilter = function(name){

    }

    this.filterWithPredicate = function(predicate, comparator){

    }

    this.fireWorker = function(workerId){

    }

    this.updateWorker = function(worker){

    }

}

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

*/


