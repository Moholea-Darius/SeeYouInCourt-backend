package com.company.model;

import com.company.model.constant.NotificationStatus;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATIONS")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "send_date")
    private String sendDate;

    @Column(name = "read_date")
    private String readDate;

    @Column(name = "status")
    private NotificationStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
