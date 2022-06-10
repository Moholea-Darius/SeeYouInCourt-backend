package com.company.dtos;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class GroupDTO {

    private int id;
    private String name;
    private String description;

}
