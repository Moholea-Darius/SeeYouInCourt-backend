package com.company.dtos.mappers;

import com.company.model.Notification;
import com.company.dtos.NotificationDTO;
import com.company.model.constants.NotificationStatus;

public class NotificationMapper {

    public static NotificationDTO toDTO(Notification notification) {
        return NotificationDTO.builder()
                .id(notification.getId())
                .sender(notification.getSender())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .sendDate(notification.getSendDate())
                .readDate(notification.getReadDate())
                .status(notification.getStatus().toString())
                .build();
    }

    public static Notification toNotification(NotificationDTO notificationDTO) {
        return Notification.builder()
                .id(notificationDTO.getId())
                .sender(notificationDTO.getSender())
                .title(notificationDTO.getTitle())
                .message(notificationDTO.getMessage())
                .sendDate(notificationDTO.getSendDate())
                .readDate(notificationDTO.getReadDate())
                .status(NotificationStatus.valueOf(notificationDTO.getStatus()))
                .build();
    }

}
