package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "ANNOUNCEMENTS")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    private String type;

    @Column(name = "send_date")
    private String sentDate;


    public Announcement(int id, String sender, String message, String type, String sentDate) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.type = type;
        this.sentDate = sentDate;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", sentDate=" + sentDate +
                '}';
    }

}
