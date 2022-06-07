package com.company.service;

import com.company.model.Notification;
import com.company.model.constants.NotificationStatus;
import com.company.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private NotificationRepo repo;
    private UserService userService;

    @Autowired
    public NotificationService(NotificationRepo repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public List<Notification> getAll() {
        return repo.findAll();
    }

    public Optional<Notification> findById(int id) {
        return repo.findById(id);
    }

    public List<Notification> findByUser(int userId) {
        return repo.findByUser(userService.findUserById(userId).get());
    }

    public void save(String sender, String title, String message, String sendDate, String readDate, String status, int userId) {
        repo.save(new Notification(sender, title, message, sendDate, readDate, status, userService.findUserById(userId).get()));
    }

    public void updateReadDate(int id, String readDate) {
        Notification notification = repo.findById(id).get();
        notification.setReadDate(readDate);
        notification.setStatus(NotificationStatus.READ.name());
        repo.save(notification);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
