package com.company.dtos.mappers;

import com.company.dtos.PrivateEventDTO;
import com.company.model.PrivateEvent;

public class PrivateEventMapper {

    public static PrivateEventDTO toDTO(PrivateEvent privateEvent) {
        return PrivateEventDTO.builder()
                .id(privateEvent.getId())
                .name(privateEvent.getName())
                .startDate(privateEvent.getStartDate())
                .endDate(privateEvent.getEndDate())
                .location(privateEvent.getLocation())
                .details(privateEvent.getDetails())
                .build();
    }

    public static PrivateEvent toPrivateEvent(PrivateEventDTO privateEventDTO) {
        return PrivateEvent.builder()
                .id(privateEventDTO.getId())
                .name(privateEventDTO.getName())
                .startDate(privateEventDTO.getStartDate())
                .endDate(privateEventDTO.getEndDate())
                .location(privateEventDTO.getLocation())
                .details(privateEventDTO.getDetails())
                .build();
    }

}
