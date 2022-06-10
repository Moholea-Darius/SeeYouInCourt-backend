package com.company.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOMS")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "max_capacity")
    private int maxCapacity;

    @Column(name = "status")
    private String status;

    public Room(int id, int number, int maxCapacity, String status) {
        this.id = id;
        this.number = number;
        this.maxCapacity = maxCapacity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", maxCapacity=" + maxCapacity +
                ", status=" + status +
                '}';
    }

}
