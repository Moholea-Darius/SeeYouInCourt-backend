package com.company.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRIVATE_EVENTS")
public class PrivateEvent extends Event {

    @Column(name = "location")
    private String location;

    @Column(name = "details")
    private String details;

    @ManyToMany
    @JoinTable(
            name = "group_private_event",
            joinColumns = @JoinColumn(name = "private_event_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    public PrivateEvent(int id, String name, String startDate, String endDate, String location, String details) {
        super(id, name, startDate, endDate);
        this.location = location;
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "PrivateEvent{" +
                "location='" + location + '\'' +
                ", details='" + details + '\'' +
                super.toString() +
                '}';
    }

}
