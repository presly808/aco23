package java8.groupbyagg;

/**
 * Created by serhii on 04.02.18.
 */
public class Department {

    public int id;
    public String name;
    public String city;

    public Department() {
    }

    public Department(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
