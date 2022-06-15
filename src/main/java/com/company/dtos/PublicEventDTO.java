package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PublicEventDTO {

    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private int roomId;

}
