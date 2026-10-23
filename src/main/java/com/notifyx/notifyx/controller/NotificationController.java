package com.notifyx.notifyx.controller;

import com.notifyx.notifyx.dto.NotificationRequestDTO;
import com.notifyx.notifyx.model.Notification;
import com.notifyx.notifyx.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // GET: Root health-check endpoint for Vercel preview
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> rootEndpoint() {
        return ResponseEntity.ok(Map.of(
            "service", "NotifyX Asynchronous Notification Service",
            "status", "UP",
            "targetRole", "Workhuman Backend Engineering Intern",
            "docs", "POST /api/v1/notifications to send notifications"
        ));
    }

    // POST: Trigger a new async notification
    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestBody NotificationRequestDTO request) {
        Notification notification = notificationService.createAndSendNotification(
                request.getRecipientEmail(),
                request.getSubject(),
                request.getBody(),
                request.getChannel()
        );
        return new ResponseEntity<>(notification, HttpStatus.CREATED);
    }

    // GET: Retrieve all notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    // GET: Retrieve a specific notification by ID to check async status
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}