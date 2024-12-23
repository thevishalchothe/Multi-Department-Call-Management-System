package com.multidepartment.call_management.administrationservice.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidepartment.call_management.administrationservice.model.Department;
import com.multidepartment.call_management.administrationservice.model.Notification;
import com.multidepartment.call_management.administrationservice.repository.DepartmentRepository;
import com.multidepartment.call_management.administrationservice.repository.NotificationRepository;
import com.multidepartment.call_management.administrationservice.serviceI.NotificationServiceI;

@Service
public class NotificationServiceImpl implements NotificationServiceI {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Notification createNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now()); // Set timestamp when notification is created
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByDepartmentId(String departmentId) {
        return notificationRepository.findByDepartmentId(departmentId);
    }

    @Override
    public void sendNotificationToDepartment(String departmentId, String message, String type) {
        // Fetch the department by its ID
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null) {
            // Create a notification
            Notification notification = new Notification();
            notification.setMessage(message);
            notification.setType(type);
            notification.setDepartmentId(departmentId);
            notification.setTimestamp(LocalDateTime.now());

            // Save the notification
            createNotification(notification);

            // Simulate sending a notification (e.g., sending an SMS)
            sendSMS(department.getMobileNumber(), message);
        }
    }

    private void sendSMS(String mobileNumber, String message) {
        // Simulate sending an SMS to the department's mobile number
        System.out.println("Sending SMS to " + mobileNumber + ": " + message);
    }
}
