# Task Management Backend (Spring Boot)

This is a **backend assignment project** for the PearlThoughts Backend Developer Internship.  
The application is built using **Spring Boot** and provides REST APIs for task management with a sync queue mechanism.

---

## 🚀 Features
- CRUD APIs for `Task` entity  
- Automatic `SyncQueue` creation for every task change  
- Background job (`SyncJob`) that processes pending sync records  
- Uses **H2 database** (for easy deployment & demo)  
- Easily switchable to MySQL (for local development)

---

## 🛠 Tech Stack
- **Java 17**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **H2 Database (in-memory)**  
- **Maven**

---

## ⚙️ Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/Karanchaurasiya-012/Task-Management-System.git
cd <Task-Management-System >
