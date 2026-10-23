package com.notifyx.notifyx.dto;

import com.notifyx.notifyx.model.Notification.NotificationChannel;

public class NotificationRequestDTO {

    private String recipientEmail;
    private String subject;
    private String body;
    private NotificationChannel channel;

    public NotificationRequestDTO() {}

    public NotificationRequestDTO(String recipientEmail, String subject, String body, NotificationChannel channel) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
        this.channel = channel;
    }

    public String getRecipientEmail() { return recipientEmail; }
    public void setRecipientEmail(String recipientEmail) { this.recipientEmail = recipientEmail; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public NotificationChannel getChannel() { return channel; }
    public void setChannel(NotificationChannel channel) { this.channel = channel; }
}