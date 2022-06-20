package com.company.dtos.mappers;

import com.company.dtos.RoomDTO;
import com.company.model.Room;
import com.company.model.constants.Status;

public class RoomMapper {

    public static RoomDTO toDTO (Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .number(room.getNumber())
                .maxCapacity(room.getMaxCapacity())
                .status(Status.valueOf(room.getStatus().toString()))
                .build();
    }

    public static Room toRoom(RoomDTO roomDTO) {
        return Room.builder()
                .id(roomDTO.getId())
                .number(roomDTO.getNumber())
                .maxCapacity(roomDTO.getMaxCapacity())
                .status(Status.valueOf(roomDTO.getStatus().toString()))
                .build();
    }
}
