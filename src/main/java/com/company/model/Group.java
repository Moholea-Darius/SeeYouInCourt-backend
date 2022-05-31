package com.company.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "groups")
    private List<PrivateEvent> privateEvents;

    @ManyToMany(mappedBy = "groups")
    private List<PublicEvent> publicEvents;

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Group(int id, String name, String description, List<PrivateEvent> privateEvents, List<PublicEvent> publicEvents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.privateEvents = privateEvents;
        this.publicEvents = publicEvents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PrivateEvent> getPrivateEvents() {
        return privateEvents;
    }

    public void setPrivateEvents(List<PrivateEvent> privateEvents) {
        this.privateEvents = privateEvents;
    }

    public List<PublicEvent> getPublicEvents() {
        return publicEvents;
    }

    public void setPublicEvents(List<PublicEvent> publicEvents) {
        this.publicEvents = publicEvents;
    }

}
