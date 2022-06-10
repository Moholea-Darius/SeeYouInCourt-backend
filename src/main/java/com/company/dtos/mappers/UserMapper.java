package com.company.dtos.mappers;

import com.company.model.User;
import com.company.dtos.UserDTO;
import com.company.model.constants.Sex;
import com.company.model.constants.UserType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        List<String> departments = new ArrayList<>(Arrays.asList(user.getDepartments().split(",")));
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .sex(user.getSex().name())
                .phoneNumber(user.getPhoneNumber())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .address(user.getAddress())
                .userType(user.getUserType().name())
                .departments(departments)
                .build();
    }

    public static User toUser(UserDTO userDTO) {
        String departments = "";
        for (String department : userDTO.getDepartments()) {
            departments = department + ",";
        }
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .sex(Sex.valueOf(userDTO.getSex()))
                .phoneNumber(userDTO.getPhoneNumber())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .userType(UserType.valueOf(userDTO.getUserType()))
                .departments(departments)
                .build();
    }


}
