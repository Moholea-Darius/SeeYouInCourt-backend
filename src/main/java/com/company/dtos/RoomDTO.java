package com.company.dtos;

import com.company.model.constants.Status;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class RoomDTO {

    private int id;
    private int number;
    private int maxCapacity;
    private Status status;

}
