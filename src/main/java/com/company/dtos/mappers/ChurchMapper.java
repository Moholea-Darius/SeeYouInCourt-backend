package com.company.dtos.mappers;

import com.company.dtos.ChurchDTO;
import com.company.model.Church;

public class ChurchMapper {

    public static ChurchDTO toDTO (Church church) {
        return ChurchDTO.builder()
                .id(church.getId())
                .name(church.getName())
                .email(church.getEmail())
                .phoneNumber(church.getPhoneNumber())
                .address(church.getAddress())
                .build();
    }

    public static Church toChurch(ChurchDTO churchDTO) {
        return Church.builder()
                .id(churchDTO.getId())
                .name(churchDTO.getName())
                .email(churchDTO.getEmail())
                .phoneNumber(churchDTO.getPhoneNumber())
                .address(churchDTO.getAddress())
                .build();
    }

}