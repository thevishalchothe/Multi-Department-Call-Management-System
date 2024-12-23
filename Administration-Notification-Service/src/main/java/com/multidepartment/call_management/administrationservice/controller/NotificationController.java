package com.multidepartment.call_management.administrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multidepartment.call_management.administrationservice.model.Notification;
import com.multidepartment.call_management.administrationservice.serviceI.NotificationServiceI;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationServiceI notificationServiceI;

    // Create a new notification
    @PostMapping("/create")
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationServiceI.createNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    // Get all notifications for a specific department
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Notification>> getNotificationsByDepartmentId(@PathVariable String departmentId) {
        List<Notification> notifications = notificationServiceI.getNotificationsByDepartmentId(departmentId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    // Send a notification to a department (e.g., missed call, emergency)
    @PostMapping("/send")
    public ResponseEntity<String> sendNotificationToDepartment(
            @RequestParam String departmentId,
            @RequestParam String message,
            @RequestParam String type) {

        notificationServiceI.sendNotificationToDepartment(departmentId, message, type);
        return new ResponseEntity<>("Notification sent successfully!", HttpStatus.OK);
    }
}
