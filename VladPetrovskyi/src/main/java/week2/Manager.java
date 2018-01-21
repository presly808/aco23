package week2;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager {



    private static final int DEFAULT_MAS_SIZE = 5;
    private String name;
    private int salary;
    private Employee mas[];
    private int size;
    private ArrayList<Employee> list;

    public Manager(){
        this("no name",DEFAULT_MAS_SIZE);
    }

   /* public Manager() {
        mas = new Employee[DEFAULT_MAS_SIZE];
    }*/


    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        mas = new Employee[DEFAULT_MAS_SIZE];
        this.list = new ArrayList<>();
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    public int calculateSalary(){

        return getSalary() * 5;
    }



    public boolean addSubworker(Employee employee){
       /* if (employee == null) {
            System.out.println("employee is null");
            return false;
        }

        if (size == mas.length) {
            System.out.println("card is full");
            return false;
        }*/

        /*list.add(employee);
*/
        return list.add(employee);
    }

    public List<Employee> getSubworkers(){
        //Manager manager = new
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
