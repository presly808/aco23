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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(String targetCity) {
        this.targetCity = targetCity;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
