package com.notifyx.notifyx.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recipientEmail;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 1000)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationChannel channel; // e.g., EMAIL, WEBHOOK, IN_APP

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status; // e.g., PENDING, SENT, FAILED

    @Column(nullable = false)
    private int retryCount = 0;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = NotificationStatus.PENDING;
    }

    // Enums for Channel and Status
    public enum NotificationChannel {
        EMAIL, WEBHOOK, IN_APP
    }

    public enum NotificationStatus {
        PENDING, SENT, FAILED
    }

    // Constructors
    public Notification() {}

    public Notification(String recipientEmail, String subject, String body, NotificationChannel channel) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
        this.channel = channel;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRecipientEmail() { return recipientEmail; }
    public void setRecipientEmail(String recipientEmail) { this.recipientEmail = recipientEmail; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public NotificationChannel getChannel() { return channel; }
    public void setChannel(NotificationChannel channel) { this.channel = channel; }

    public NotificationStatus getStatus() { return status; }
    public void setStatus(NotificationStatus status) { this.status = status; }

    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}