# Inventory Management System (IMS) for End User Equipment

## 1. Project Overview
This is a professional, offline-capable Inventory Management System (IMS) developed for **Airtel** to solve the challenge of tracking and managing end-user devices such as laptops, desktops, and mobile phones. The application is built using the **Spring Boot MVC** framework, ensuring a robust and scalable architecture.

## 2. Key Features
- **Secure Authentication:** Role-based login system protecting administrative routes.
- **Interactive Landing Page:** Personalized welcome screen for logged-in users.
- **Advanced Inventory Management:** Full CRUD (Create, Read, Update, Delete) for hardware assets.
- **Admin Panel (User Management):** A dedicated interface for the SysAdmin to manage team members (Financiers, Managers, etc.) and assign roles.
- **Search & Filtering:** Real-time search functionality across serial numbers, brands, and device status.
- **Automated Reporting:** A comprehensive reports dashboard with statistical cards and print-to-PDF capabilities.
- **Error Handling:** Graceful handling of duplicate entries (e.g., duplicate User IDs) with user-friendly alerts.

## 3. Technology Stack
- **Backend:** Java 21, Spring Boot 3.x, Spring Data JPA
- **Frontend:** Thymeleaf Template Engine, Tailwind CSS (Modern UI)
- **Database:** MySQL 8.0 / MariaDB
- **Server:** Embedded Apache Tomcat (Port 8080)

## 4. SysAdmin Credentials (Seeded)
To access the full management features of the system, use the following credentials:
- **Username:** 24rp01734
- **Password:** 24rp04260

## 5. Setup & Installation
1. **Database:** Import the provided `ims.sql` file into your local MySQL server.
2. **Configuration:** Update `src/main/resources/application.properties` with your local MySQL password.
3. **Run:** Execute the `ImsApplication.java` file from your IDE.
4. **Access:** Open your browser and navigate to `http://localhost:8080`.

## 6. Project Structure
- `IMS/`: Main Spring Boot project workspace.
- `ims.sql`: Database backup and seeding script.
- `README.md`: System documentation and setup guide.

---

### Developed By:
- **DUFITUMUCUNGUZI Dieudonne** (Reg No: **24rp01734**)
- **DUFITIMANA Israel** (Reg No: **24rp04260**)