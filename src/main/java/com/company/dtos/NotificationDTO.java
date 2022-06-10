package com.company.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NotificationDTO {

    private int id;
    private String sender;
    private String title;
    private String message;
    private String sendDate;
    private String readDate;
    private String status;

}
