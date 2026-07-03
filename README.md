# 💼 Job Portal Application

A modern Full-Stack **Job Portal Application** built using **Java, Spring Boot, MySQL, HTML, CSS, and JavaScript**.

The application allows users to register, log in, search for jobs, apply by uploading their resume, and track submitted applications. It also provides an Admin Dashboard where administrators can manage job postings and review candidate applications.

This project was developed to gain hands-on experience in building a complete full-stack application using Java technologies while implementing CRUD operations, REST APIs, file uploads, database integration, and responsive frontend development.

---

# 🚀 Technologies Used

| **Category** | **Technologies**                                            |
| ------------ | ----------------------------------------------------------- |
| 💻 Frontend  | HTML5, CSS3, JavaScript                                     |
| ⚙️ Backend   | Java, Spring Boot, Spring MVC                               |
| 🗄️ Database | MySQL, Spring Data JPA (Hibernate)                          |
| 🔌 APIs      | REST APIs                                                   |
| 🛠️ Tools    | IntelliJ IDEA, Maven, Git, GitHub, Postman, MySQL Workbench |

---


# ✨ Features

- 🔐 User Registration & Secure Login
- 🔍 Search and Filter Jobs by Role, Location, and Job Type
- 📄 View Job Details and Apply with Resume Upload
- 📋 Track Applied Jobs through My Applications
- 👨‍💼 Admin Dashboard to Add, Edit, Update, Delete, and Manage Jobs
- 💾 MySQL Database Integration with Complete CRUD Operations

---

# 📋 User Workflow

```text
User Registration
        │
        ▼
User Login
        │
        ▼
Search Jobs
        │
        ▼
View Job Details
        │
        ▼
Upload Resume
        │
        ▼
Submit Application
        │
        ▼
Success Page
        │
        ▼
My Applications
```

---

# 🔑 Admin Workflow

```text
Admin Login
      │
      ▼
Dashboard
      │
      ▼
Add Jobs
      │
      ▼
Edit Jobs
      │
      ▼
Delete Jobs
      │
      ▼
View Candidate Applications
```

---

# 📂 Project Structure

```
job-portal
│
├── src
│   ├── main
│   │
│   ├── java
│   │     └── controller
│   │     └── entity
│   │     └── repository
│   │     └── service
│   │
│   ├── resources
│   │     ├── static
│   │     ├── templates
│   │     └── application.properties
│
├── database.sql
├── pom.xml
└── README.md
```


# 💡 Challenges Faced

Some challenges encountered while developing this project included:

- Connecting frontend with Spring Boot APIs
- Managing MySQL database schema
- Handling multipart resume uploads
- Debugging API requests
- Designing the Admin Dashboard
- Maintaining project structure

These challenges improved my debugging and problem-solving skills.

---

# 🔮 Future Improvements

Future enhancements planned for this project include:

- 🔒 Add Secure Login using Spring Security and JWT Authentication
- 🔑 Encrypt User Passwords using BCrypt
- 📧 Send Email Notifications after Job Applications
- 📄 Allow Admin to View and Download Resumes
- 🔍 Add Advanced Search Filters and Pagination
- 👤 Implement User Profile and Forgot Password Features
- 📊 Add Dashboard Analytics and Reports
- ☁️ Deploy the Application on AWS or Render

---

# ⚙️ Installation

Clone the repository

```bash
git clone https://github.com/yourusername/job-portal.git
```

Move into project directory

```bash
cd job-portal
```

Create database

```sql
CREATE DATABASE job_portal_db;
```

Run

```
database.sql
```

Update

```
application.properties
```

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

Run

```
JobportalApplication.java
```

Open

```
http://localhost:9090
```

---

# 🔐 Login Credentials

## Admin

```
Email:
admin@jobportal.com

Password:
admin123
```

## User

Create an account using the Registration page.

---

# 🎥 Project Demo

Add your project demo here.

```
https://youtu.be/your-video-link
```

or

```
https://drive.google.com/...
```


# 👩‍💻 Author

**Likhitha**

Java Full-Stack Developer

⭐ If you found this project useful, consider giving it a star on GitHub!
