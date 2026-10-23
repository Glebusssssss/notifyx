package com.notifyx.notifyx.repository;

import com.notifyx.notifyx.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Custom query method to find all notifications sent to a specific recipient email
    List<Notification> findByRecipientEmail(String recipientEmail);

    // Custom query method to find notifications by their delivery status (e.g., PENDING, FAILED)
    List<Notification> findByStatus(Notification.NotificationStatus status);
}