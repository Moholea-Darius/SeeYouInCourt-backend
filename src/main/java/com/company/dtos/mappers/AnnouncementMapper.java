package com.company.dtos.mappers;

import com.company.dtos.AnnouncementDTO;
import com.company.model.Announcement;
import com.company.model.constants.AnnouncementType;


public class AnnouncementMapper {

    public static AnnouncementDTO toDTO(Announcement announcement) {
        return AnnouncementDTO.builder()
                .id(announcement.getId())
                .sender(announcement.getSender())
                .message(announcement.getMessage())
                .type(String.valueOf(announcement.getType()))
                .sendDate(announcement.getSentDate())
                .build();
    }

    public static Announcement toAnnouncement(AnnouncementDTO announcementDTO) {
        return Announcement.builder()
                .id(announcementDTO.getId())
                .sender(announcementDTO.getSender())
                .message(announcementDTO.getMessage())
                .type(AnnouncementType.valueOf(announcementDTO.getType()))
                .sentDate(announcementDTO.getSendDate())
                .build();
    }

}
