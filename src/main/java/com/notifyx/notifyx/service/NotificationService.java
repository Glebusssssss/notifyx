package com.notifyx.notifyx.service;

import com.notifyx.notifyx.model.Notification;
import com.notifyx.notifyx.repository.NotificationRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Create a new notification and trigger asynchronous dispatch
    public Notification createAndSendNotification(String recipientEmail, String subject, String body, Notification.NotificationChannel channel) {
        Notification notification = new Notification(recipientEmail, subject, body, channel);
        Notification savedNotification = notificationRepository.save(notification);

        // Asynchronously process and send the notification
        processNotificationAsync(savedNotification.getId());

        return savedNotification;
    }

    // Asynchronous background task simulation
    @Async
    public void processNotificationAsync(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.findById(notificationId);
        
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            try {
                // Simulate network latency / external API delivery delay (e.g., Email/Webhook provider)
                Thread.sleep(2000);

                // Simulate successful delivery update
                notification.setStatus(Notification.NotificationStatus.SENT);
                notificationRepository.save(notification);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                notification.setStatus(Notification.NotificationStatus.FAILED);
                notification.setRetryCount(notification.getRetryCount() + 1);
                notificationRepository.save(notification);
            }
        }
    }

    // Fetch all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Fetch a single notification by ID
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }
}