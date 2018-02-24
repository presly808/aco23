package projectzero.model;

public class Order {

    private final int id;
    private String name;
    private int price;

    public Order(int id) {
        this.id = id;
    }

    public Order(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
