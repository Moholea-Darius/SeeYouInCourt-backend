package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "send_date")
    private String sendDate;

    @Column(name = "read_date")
    private String readDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Notification(int id, String sender, String title, String message, String sendDate, String readDate, String status) {
        this.id = id;
        this.sender = sender;
        this.title = title;
        this.message = message;
        this.sendDate = sendDate;
        this.readDate = readDate;
        this.status = status;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", sendDate=" + sendDate +
                ", readDate=" + readDate +
                ", status=" + status +
                '}';
    }

}
