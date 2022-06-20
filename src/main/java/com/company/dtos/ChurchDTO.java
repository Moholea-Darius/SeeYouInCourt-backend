package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ChurchDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private String address;

}
