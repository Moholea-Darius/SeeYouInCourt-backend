package com.company.dtos.mappers;

import com.company.dtos.ChurchDTO;
import com.company.model.Church;

public class ChurchMapper {

    public static ChurchDTO toDTO (Church church) {
        return ChurchDTO.builder()
                .name(church.getName())
                .email(church.getEmail())
                .phoneNumber(church.getPhoneNumber())
                .address(church.getAddress())
                .build();
    }

    public static Church toChurch(ChurchDTO churchDTO) {
        return Church.builder()
                .name(churchDTO.getName())
                .email(churchDTO.getEmail())
                .phoneNumber(churchDTO.getPhoneNumber())
                .address(churchDTO.getAddress())
                .build();
    }

}
