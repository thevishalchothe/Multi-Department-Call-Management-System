# **Multi-Department Call Management System** 🏢📞💼

## **Project Overview** 🌐  
The **Multi-Department Call Management System** is a scalable solution designed to manage calls within multi-department organizations. Key features include **call logging**, **department management**, **emergency call handling**, and **real-time notifications**. A core highlight is the **Call Routing** capability, which directs calls to specific departments or services based on dialed inputs (e.g., "1" for HR, "2" for IT). Built using a **microservices architecture**, this system ensures flexibility, scalability, and maintainability.

---

## **Features Grouped into Two Core Services** ✨  

### **1. Communication Management Service** 📞🛠️  
This service handles all communication-related functionalities, including:

- **Call Logs Management** 📜: Tracks and manages call data (source, destination, timestamps, and call types).  
- **Emergency Call Management** 🚨: Records and processes high-priority emergency calls with follow-up actions.  
- **Call Routing** 🔄: Routes incoming calls to departments based on dialed numbers (e.g., "1" for HR, "2" for IT, etc.).  
- **Room/Extension Management** 🏠 (Optional): Manages room-specific extensions for scalability.  

### **2. Administration and Notification Service** 🏢👤📢  
This service focuses on administrative and notification-related tasks, including:

- **Department Management** 🏢: Manages department details like contact information and extension numbers.  
- **User Management** 👤: Adds, updates, and assigns user roles with appropriate access permissions.  
- **Phone Directory** 📖: Maintains an organized list of department extensions for quick reference.  
- **Notifications and Alerts** 📢: Generates real-time notifications for missed calls, emergencies, and other critical updates.  

---


## **Technologies Used** ✅

- **Java** ☕️: Used as the primary programming language for the project.
- **Spring Boot** 🌱: Used for building the microservices architecture. Both the Communication Management Service and Administration Service are implemented using Spring Boot.
- **Spring Data MongoDB** 🗄️: Provides integration with MongoDB, allowing seamless interaction with the database using repositories and other data access features.
- **MongoDB** 🗄️: Used as the NoSQL database for storing data related to departments, call logs, and notifications. All the repositories use MongoDB as the database.
- **Lombok** 📜: Used to reduce boilerplate code, e.g., in model classes like CallLog, Department, and Notification.
- **RestTemplate** 🔄: Used for making synchronous HTTP requests to external services.
- **Postman** 🔑: Not explicitly mentioned, but Postman is used for API testing (as mentioned in the project's context) to validate the API endpoints.
  
---

## **Getting Started** 🚀

### **Prerequisites** 🛠️

Before you begin, make sure you have the following installed:

- **Java JDK 11 or later**: Download from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
- **Postman**: Install for API testing from [Postman's website](https://www.postman.com/downloads/).
- **Eclipse IDE**: Download from [Eclipse's website](https://www.eclipse.org/downloads/packages/release/2023-09/r) or use your preferred IDE.
- **MongoDB**: Download and set up from [MongoDB's website](https://www.mongodb.com/try/download/community).

### **Installation** 🛠️

1. **Clone the repository**:
   ```bash
   git clone https://github.com/thevishalchothe/call-management-system.git
   ```
2. **Navigate to the project folder**:
   ```bash
   cd call-management-system
   ```
3. **Import the project into your IDE**:
   - Open Eclipse or your preferred IDE.
   - Import the project as a Maven project.
4. **Set up MongoDB database**:
   - Run the MongoDB server.
   - Configure your database settings in `application.properties` or `application.yml`.
   - Example MongoDB configuration:
     ```properties
     spring.data.mongodb.host=localhost
     spring.data.mongodb.port=27017
     spring.data.mongodb.database=call_management_system
     ```
5. **Run the application**:
   - Start the Spring Boot application by running the `CallManagementSystemApplication.java` class.

---

## **Testing the APIs** 🧪

Use **Postman** or any other API testing tool to test the following endpoints:

- **POST /api/department** 🏢: Create a new department.
- **GET /api/department/{id}** 🏢: Retrieve department details.
- **POST /api/calllog** 📞: Log a new call.
- **GET /api/calllog/{id}** 📞: Retrieve call log details.
- **POST /api/emergencycall** 🚨: Log an emergency call.
- **POST /api/user** 👤: Add a new user to the system.
- **POST /api/notification** 📲: Send a new notification to users.

---

## **Call Routing** 📞🔄

The system implements **Call Routing** to direct incoming calls to the appropriate department. Here are the current dial numbers:

- **Dial "1"** 📞: HR Department
- **Dial "2"** 📞: IT Manager
- **Dial "3"** 📞: Receptionist
- **Dial "4"** 📞: Support Manager
- **Dial "7"** 📞: Security  
(Additional departments can be added as needed.)

---

## **Contributing** 💡

We welcome contributions to the **Call Management System**! Here's how you can contribute:

1. Fork the repository and create a new branch.
2. Implement your feature or fix the bug.
3. Commit your changes and submit a pull request.
4. If you're reporting an issue, provide as many details as possible to help resolve it faster.

For any assistance or inquiries, feel free to contact me at [vishalchothe134@gmail.com](mailto:vishalchothe134@gmail.com).

---

## **License** 📜

Using an open-source license promotes professional software development, encouraging collaboration and contributions from the community.  
See the [LICENSE](https://github.com/thevishalchothe) file for more information.

---

## **Thank You and Best Regards!** 🙏🎉

