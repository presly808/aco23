package projectzero.model;

public class Employee {

    private final int id;
    private String name;
    private long token;

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, long token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getToken() {
        return token;
    }

    public void setToken(long token) {
        this.token = token;
    }

    @Override
    public java.lang.String toString() {
        return "Employee{" +
                "id=" + id + '}';
    }
}
