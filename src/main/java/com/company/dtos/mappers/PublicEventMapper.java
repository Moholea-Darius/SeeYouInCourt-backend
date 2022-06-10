package com.company.dtos.mappers;

import com.company.dtos.PublicEventDTO;
import com.company.model.PublicEvent;

public class PublicEventMapper {

    public static PublicEventDTO toDTO(PublicEvent publicEvent) {
        return PublicEventDTO.builder()
                .id(publicEvent.getId())
                .name(publicEvent.getName())
                .startDate(publicEvent.getStartDate())
                .endDate(publicEvent.getEndDate())
                .roomId(publicEvent.getRoomId())
                .build();
    }

    public static PublicEvent toPublicEvent(PublicEventDTO publicEventDTO) {
        return PublicEvent.builder()
                .id(publicEventDTO.getId())
                .name(publicEventDTO.getName())
                .startDate(publicEventDTO.getStartDate())
                .endDate(publicEventDTO.getEndDate())
                .roomId(publicEventDTO.getRoomId())
                .build();
    }

}
