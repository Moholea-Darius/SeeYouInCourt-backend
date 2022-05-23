package model;

import java.time.LocalDateTime;

public class Announcement {

    private int id;
    private String sender;
    private String message;
    private AnnouncementType type;
    private LocalDateTime dataSent;
    private int churchId;

    public Announcement(int id, String sender, String message, AnnouncementType type, LocalDateTime dataSent, int churchId) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.type = type;
        this.dataSent = dataSent;
        this.churchId = churchId;
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

    public AnnouncementType getType() {
        return type;
    }

    public void setType(AnnouncementType type) {
        this.type = type;
    }

    public LocalDateTime getDataSent() {
        return dataSent;
    }

    public void setDataSent(LocalDateTime dataSent) {
        this.dataSent = dataSent;
    }

    public int getChurchId() {
        return churchId;
    }

    public void setChurchId(int churchId) {
        this.churchId = churchId;
    }
}
