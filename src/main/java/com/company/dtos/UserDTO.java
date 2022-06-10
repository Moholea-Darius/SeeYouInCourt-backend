package com.company.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String sex;
    private String phoneNumber;
    private String username;
    private String password;
    private String email;
    private String address;
    private String userType;
    private List<String> departments;

}
