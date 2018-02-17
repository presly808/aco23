class User{

    // assign all input arguments to this


    constructor(id, name, salary) {
        this._id = id;
        this._name = name;
        this._salary = salary;
    }

    // create method toString


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

// calculate salary

    get salary() {
        return this._salary;
    }

    set salary(value) {
        this._salary = value;
    }


}

class Manager extends User {

    const subworkerList; //??

    constructor(id, name, salary, subworkerList) {
        super(id, name, salary);
        this._subworkerList = subworkerList;

        }

    const addSubworker = (user) => {
                return subworkerList.push(user);
            };

    const removeSubworker = () => {
            return subworkerList.pop;
        };

    // getAllSubworkers
    // calculate salary

   const removeSubworker = () => { subworkerList.forEach (function(user)) {
           salary += user.getSalary()};
           return salary;
       }


    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get salary() {
        return this._salary;
    }

    set salary(value) {
        this._salary = value;
    }

    get subworkerList() {
        return this._subworkerList;
    }

    set subworkerList(value) {
        this._subworkerList = value;
    }


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

}

