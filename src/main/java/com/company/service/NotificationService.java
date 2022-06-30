package com.company.service;

import com.company.model.Notification;
import com.company.model.User;
import com.company.model.constant.NotificationStatus;
import com.company.dtos.NotificationDTO;
import com.company.dtos.mappers.NotificationMapper;
import com.company.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private NotificationRepo repo;
    private UserService userService;

    @Autowired
    public NotificationService(NotificationRepo repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public List<NotificationDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(NotificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NotificationDTO findById(int id) {
        Optional<Notification> optionalNotification = repo.findById(id);

        if (optionalNotification.isEmpty()) {
            throw new IllegalArgumentException("Notification not found!");
        }
        return NotificationMapper.toDTO(optionalNotification.get());
    }

    public List<NotificationDTO> findByUserId(int userId) {
        Optional<User> userOptional = userService.findUserByIdForEntities(userId);

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found!");
        }

        List<Notification> notification = userOptional.get().getNotifications();
        return notification
                .stream()
                .map(NotificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public NotificationDTO save(NotificationDTO notificationDTO, int userId) {
        Notification notification = NotificationMapper.toNotification(notificationDTO);

        Optional<User> optionalUser = userService.findUserByIdForEntities(userId);
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found!");
        }
        notification.setUser(optionalUser.get());

        Notification savedNotification = repo.save(notification);
        return NotificationMapper.toDTO(savedNotification);
    }

    public NotificationDTO updateReadDate(int id, String readDate) {
        Optional<Notification> optionalNotification = repo.findById(id);

        if (optionalNotification.isEmpty()) {
            throw new IllegalArgumentException("Notification not found!");
        }
        optionalNotification.get().setReadDate(readDate);
        optionalNotification.get().setStatus(NotificationStatus.READ);

        Notification notification = repo.save(optionalNotification.get());
        return NotificationMapper.toDTO(notification);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
