package com.company.controller;

import com.company.model.Notification;
import com.company.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @GetMapping(path = "/findAll")
    public List<Notification> getCars() {
        return service.getAll();
    }

    @GetMapping(path = "/findById")
    @ResponseBody
    public Optional<Notification> findById(@RequestParam("id") int id) {
        return service.findById(id);
    }

    @GetMapping(path = "/findByUserId")
    public List<Notification> findByUserId(@RequestParam("userId") int userId) {
        return service.findByUser(userId);
    }

    @PostMapping(path = "/save")
    public void save(@RequestParam("sender") String sender, @RequestParam("title") String title, @RequestParam("message") String message, @RequestParam("sendDate") String sendDate, @RequestParam("readDate") String readDate, @RequestParam("status") String status, @RequestParam("userId") int userId) {
        service.save(sender, title, message, sendDate, readDate, status, userId);
    }

    @PutMapping(path = "/update")
    public void updateReadDate(@RequestParam("messageId") int id, @RequestParam("readDate") String readDate) {
        service.updateReadDate(id, readDate);
    }

    @DeleteMapping(path = "/delete")
    public void deleteById(@RequestParam("id") int id) {
        service.deleteById(id);
    }

}
