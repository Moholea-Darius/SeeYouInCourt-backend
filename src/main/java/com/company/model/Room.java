package com.company.model;

import javax.persistence.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
