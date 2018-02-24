package projectzero.model;

public class Order {

    private final int id;
    private String name;
    private int price;
    private String status;

    public Order(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Order(int id, String name, int price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
