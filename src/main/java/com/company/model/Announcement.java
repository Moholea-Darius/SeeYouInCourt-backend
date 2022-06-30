package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ANNOUNCEMENTS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
