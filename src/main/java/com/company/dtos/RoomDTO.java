package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoomDTO {

    private int id;
    private int number;
    private int maxCapacity;
    private String status;

}
