package com.company.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

}
