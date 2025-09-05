# Task Management Backend (Spring Boot)

This is a **backend assignment project** for the *PearlThoughts Backend Developer Internship*.  
The application is built using **Spring Boot** and provides REST APIs for task management with a **sync queue mechanism**.

---

## Features
- CRUD APIs for `Task` entity  
- Automatic `SyncQueue` creation for every task change  
- Background job (`SyncJob`) that processes pending sync records  
- Uses **H2 in-memory database** for easy deployment & demo  
- Easily switchable to **MySQL** for local development  

---

## Tech Stack
- **Java 17**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **H2 Database** (in-memory)  
- **Maven**  

---

## Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/Karanchaurasiya-012/Task-Management-System.git
cd Task-Management-System
```

### 2. Configure Database
By default, the project uses **H2 in-memory database**.  

If you want to use **MySQL** locally, update `src/main/resources/application.properties`:  

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run Application
```bash
mvn spring-boot:run
```

---

## API Endpoints

### Task APIs
- `POST /api/tasks` → Create a new task  
- `GET /api/tasks` → Get all tasks  
- `GET /api/tasks/{id}` → Get task by ID  
- `PUT /api/tasks/{id}` → Update a task  
- `DELETE /api/tasks/{id}` → Delete a task  
- `backend ulr` -> https://task-management-system-jq9f.onrender.com
- `example for postman to create task in postman`-> https://task-management-system-jq9f.onrender.com/api/tasks
---

## 🗄 Database Console (H2)
H2 console is available at:  
 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  

---

## Notes
- Default DB is **H2** for testing.  
- Switch to **MySQL** for production/local dev as needed.  
