package com.company.service;

import com.company.dtos.AnnouncementDTO;
import com.company.dtos.mappers.AnnouncementMapper;
import com.company.model.Announcement;
import com.company.repository.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class AnnouncementService {

    private AnnouncementRepo repo;

    @Autowired
    public AnnouncementService (AnnouncementRepo repo) {

        this.repo = repo;
    }

    public List<AnnouncementDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(AnnouncementMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AnnouncementDTO findById (int id) {
        Optional<Announcement> optionalAnnouncement = repo.findById(id);
        if (optionalAnnouncement.isEmpty()) {
            throw new IllegalArgumentException("Announcement not found!");
        }
        return AnnouncementMapper.toDTO(optionalAnnouncement.get());
    }

    public AnnouncementDTO add (AnnouncementDTO announcementDTO) {
        Announcement savedAnnouncement = repo.save(AnnouncementMapper.toAnnouncement(announcementDTO));
        return AnnouncementMapper.toDTO(savedAnnouncement);
    }

    public void deleteById(int id) throws IllegalArgumentException {
        findById(id);
        repo.deleteById(id);
    }

    public List<AnnouncementDTO> getLastThreeAnnouncements() {
        List<Announcement> announcement = repo.findAll();
        if (announcement.isEmpty()) {
            throw new IllegalArgumentException("No Announcements!");
        }
       return announcement.subList(Math.max(announcement.size()-3,0), announcement.size())
               .stream()
               .map(AnnouncementMapper::toDTO)
               .collect(Collectors.toList());
    }


}
