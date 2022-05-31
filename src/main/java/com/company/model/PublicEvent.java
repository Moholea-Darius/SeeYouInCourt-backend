package com.company.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PUBLIC_EVENTS")
public class PublicEvent extends Event {

    @Column(name = "room_id")
    private int roomId;

    @ManyToMany
    @JoinTable(
            name = "group_public_event",
            joinColumns = @JoinColumn(name = "public_event_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    public PublicEvent(int id, String name, String startDate, String endDate, int roomId) {
        super(id, name, startDate, endDate);
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

}
