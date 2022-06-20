package com.company.model;

import com.company.model.constants.Status;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@ToString
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
    private Status status;

}
