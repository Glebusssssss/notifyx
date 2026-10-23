package com.notifyx.notifyx.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> rootEndpoint() {
        return ResponseEntity.ok(Map.of(
            "service", "NotifyX Asynchronous Notification Service",
            "status", "UP",
            "targetRole", "Workhuman Backend Engineering Intern",
            "docs", "POST /api/v1/notifications to send notifications"
        ));
    }
}
