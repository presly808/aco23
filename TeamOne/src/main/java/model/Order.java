package model;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private String senderName;
    private String receiverName;
    private String targetCity;
    private LocalDateTime sendDate;
    private String status;

    public Order() {
    }

    public Order(String senderName, String receiverName, String targetCity) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.targetCity = targetCity;
    }

    @Override
    public String toString() {
        return "Order id: " + id +
                ", senderName: " + senderName + '\'' +
                ", receiverName: " + receiverName + '\'' +
                ", targetCity: " + targetCity + '\'' +
                ", sendDate: " + sendDate +
                ", status" + status + '\'' +
                '}';
    }
}
