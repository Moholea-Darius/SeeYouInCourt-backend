package model;

import java.time.LocalDateTime;

public class Notification {

    private int id;
    private String sender;
    private String name;
    private String message;
    private LocalDateTime dataSend;
    private LocalDateTime dataRead;
    private NotificationStatus status;
    private int userId;

    public Notification(int id, String sender, String name, String message, LocalDateTime dataSend, LocalDateTime dataRead, NotificationStatus status, int userId) {
        this.id = id;
        this.sender = sender;
        this.name = name;
        this.message = message;
        this.dataSend = dataSend;
        this.dataRead = dataRead;
        this.status = status;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDataSend() {
        return dataSend;
    }

    public void setDataSend(LocalDateTime dataSend) {
        this.dataSend = dataSend;
    }

    public LocalDateTime getDataRead() {
        return dataRead;
    }

    public void setDataRead(LocalDateTime dataRead) {
        this.dataRead = dataRead;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
