package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

}
