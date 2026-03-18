#Vinyl Record Inventory System

A full-stack Spring Boot web application for managing a vinyl record collection.  
Built as part of a software development project, this application demonstrates backend development, database integration, and MVC architecture.

---

## Features

-  Add new vinyl records
-  Edit existing records
-  Delete records
-  View detailed record information
-  List all records
-  Persistent storage using H2 database

---

##  Tech Stack

- **Java 23**
- **Spring Boot 4**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database**
- **Thymeleaf (Server-side rendering)**
- **Maven**

---

##  Project Structure
src/main/java/edu/cscc/lab12/
│
├── model/ # Entity classes (VinylRecord, RecordSize)
├── repo/ # Repository interfaces (JPA)
├── web/ # Controllers (MVC logic)
└── Lab12Application.java

---

##  How to Run the Application

### 1. Clone the repository

```bash
git clone https://github.com/jamesBranco/spring-boot-vinyl-app.git
cd spring-boot-vinyl-app
