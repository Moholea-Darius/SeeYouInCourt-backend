package com.company.controller;

import com.company.dtos.NotificationDTO;
import com.company.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        List<NotificationDTO> notificationDTOS = service.findAll();
        if (notificationDTOS.isEmpty()) {
            return new ResponseEntity<>("There are no notifications!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            NotificationDTO notificationDTO = service.findById(id);
            return new ResponseEntity<>(notificationDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/findByUserId")
    public ResponseEntity<Object> findByUserId(@RequestParam("userId") int userId) {
        try {
            return new ResponseEntity<>(service.findByUserId(userId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Object> save(@RequestBody NotificationDTO notificationDTO, @RequestParam("userId") int userId) {
        try {
            return new ResponseEntity<>(service.save(notificationDTO, userId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> updateReadDate(@RequestParam("messageId") int id, @RequestParam("readDate") String readDate) {
        try {
            return new ResponseEntity<>(service.updateReadDate(id, readDate), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteById(@RequestParam("id") int id) {
        service.deleteById(id);
        return new ResponseEntity("Notification deleted!", HttpStatus.OK);
    }

}
