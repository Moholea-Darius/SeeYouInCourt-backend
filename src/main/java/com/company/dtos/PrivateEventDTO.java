package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PrivateEventDTO {

    private int id;
    private String name;
    private String startDate;
    private String endDate;
    private String location;
    private String details;

}
