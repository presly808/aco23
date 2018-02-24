package model;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private String senderName;
    private String recieverName;
    private String targetCity;
    private LocalDateTime sendDate;
    private String status;

    public Order() {
    }

    public Order(String senderName, String recieverName, String targetCity) {
        this.senderName = senderName;
        this.recieverName = recieverName;
        this.targetCity = targetCity;
    }
}
