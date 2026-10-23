package com.notifyx.notifyx.service;

import com.notifyx.notifyx.model.Notification;
import com.notifyx.notifyx.repository.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService notificationService;

    private Notification sampleNotification;

    @BeforeEach
    void setUp() {
        sampleNotification = new Notification(
                "user@workhuman.com",
                "Recognition Received!",
                "You received a new recognition award from your teammate.",
                Notification.NotificationChannel.EMAIL
        );
        sampleNotification.setId(1L);
    }

    @Test
    @DisplayName("Should create and return initial pending notification")
    void shouldCreateAndSendNotification() {
        // Arrange
        when(notificationRepository.save(any(Notification.class))).thenReturn(sampleNotification);

        // Act
        Notification created = notificationService.createAndSendNotification(
                "user@workhuman.com",
                "Recognition Received!",
                "You received a new recognition award from your teammate.",
                Notification.NotificationChannel.EMAIL
        );

        // Assert
        assertNotNull(created);
        assertEquals(1L, created.getId());
        assertEquals("user@workhuman.com", created.getRecipientEmail());
        verify(notificationRepository, times(1)).save(any(Notification.class));
    }

    @Test
    @DisplayName("Should retrieve notification by ID when present")
    void shouldGetNotificationById() {
        // Arrange
        when(notificationRepository.findById(1L)).thenReturn(Optional.of(sampleNotification));

        // Act
        Optional<Notification> result = notificationService.getNotificationById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("user@workhuman.com", result.get().getRecipientEmail());
        verify(notificationRepository, times(1)).findById(1L);
    }
}