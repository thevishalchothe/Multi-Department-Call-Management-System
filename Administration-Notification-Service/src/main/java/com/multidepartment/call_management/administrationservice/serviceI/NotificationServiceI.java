package com.multidepartment.call_management.administrationservice.serviceI;

import java.util.List;

import com.multidepartment.call_management.administrationservice.model.Notification;

public interface NotificationServiceI {

	Notification createNotification(Notification notification);

	List<Notification> getNotificationsByDepartmentId(String departmentId);

	void sendNotificationToDepartment(String departmentId, String message, String type);

	

}
