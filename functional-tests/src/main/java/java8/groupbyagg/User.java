package java8.groupbyagg;

/**
 * Created by serhii on 04.02.18.
 */
public class User {

    public int id;
    public String name;
    public double money;
    public Department department;

    public User() {
    }

    public User(int id, String name, double money, Department department) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
