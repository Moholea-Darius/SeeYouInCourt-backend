package com.company.model;

import com.company.model.constants.Sex;
import com.company.model.constants.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex")
    private Sex sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "departments")
    private String departments;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

}
