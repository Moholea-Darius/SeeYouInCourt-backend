package com.company.model;

import com.company.model.constant.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOMS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Status status;

}
