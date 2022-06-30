package com.company.controller;


import com.company.dtos.AnnouncementDTO;
import com.company.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")

public class AnnouncementController {

    @Autowired
    private AnnouncementService service;

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        List<AnnouncementDTO> announcementDTOS = service.findAll();
        if (announcementDTOS.isEmpty()) {
            return new ResponseEntity<>("There are no announcements!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(announcementDTOS, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            AnnouncementDTO announcementDTO = service.findById(id);
            return new ResponseEntity<>(announcementDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody AnnouncementDTO announcementDTO) {
        return new ResponseEntity<>(service.add(announcementDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteById(@RequestParam("id") int id) {
        try {
            service.deleteById(id);
            return new ResponseEntity("Announcement deleted!", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Announcement ID not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/getLastThreeAnnouncements")
    public ResponseEntity<Object> getLastThreeAnnouncements() {
        try {
            return new ResponseEntity<>(service.getLastThreeAnnouncements(), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
