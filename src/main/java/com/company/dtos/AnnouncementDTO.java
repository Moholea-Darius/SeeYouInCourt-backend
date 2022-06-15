package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class AnnouncementDTO {

    private int id;
    private String sender;
    private String message;
    private String type;
    private String sendDate;

}
