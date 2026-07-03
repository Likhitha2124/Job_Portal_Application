DROP DATABASE IF EXISTS job_portal_db;
CREATE DATABASE job_portal_db;
USE job_portal_db;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE jobs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    company VARCHAR(255),
    location VARCHAR(255),
    job_type VARCHAR(255),
    experience VARCHAR(255),
    salary VARCHAR(255),
    description VARCHAR(2000)
);

CREATE TABLE applications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    job_id BIGINT,
    job_title VARCHAR(255),
    applicant_name VARCHAR(255),
    phone VARCHAR(50),
    email VARCHAR(255),
    resume_file_name VARCHAR(255),
    applied_at DATETIME
);

INSERT INTO users (full_name, email, password, role) VALUES
('Admin', 'admin@jobportal.com', 'admin123', 'ADMIN');

INSERT INTO jobs (title, company, location, job_type, experience, salary, description) VALUES
('Software Developer', 'TCS', 'Bengaluru', 'Full Time', 'Fresher', '3.5 LPA', 'Java, Spring Boot, SQL developer role for freshers'),
('Software Engineer', 'Infosys', 'Hyderabad', 'Full Time', 'Fresher', '4 LPA', 'Software engineering role for fresher candidates'),
('Full Stack Developer', 'Wipro', 'Bengaluru', 'Full Time', '0-1 Years', '4.2 LPA', 'Java Spring Boot and frontend development role'),
('Frontend Developer', 'Zoho', 'Chennai', 'Full Time', 'Fresher', '5 LPA', 'HTML, CSS, JavaScript frontend role'),
('Business Analyst', 'Deloitte', 'Bengaluru', 'Full Time', 'Fresher', '4.5 LPA', 'Business analysis and requirement gathering role'),
('Data Analyst', 'Accenture', 'Hyderabad', 'Full Time', 'Fresher', '4 LPA', 'SQL, Excel and dashboard analysis role'),
('Backend Developer', 'HCLTech', 'Noida', 'Full Time', '0-1 Years', '3.8 LPA', 'Java backend development role'),
('Java Developer', 'Capgemini', 'Pune', 'Full Time', 'Fresher', '4 LPA', 'Core Java, Spring Boot and REST API role'),
('Analyst', 'Cognizant', 'Bengaluru', 'Full Time', 'Fresher', '3.6 LPA', 'Entry-level analyst role'),
('Software Developer Intern', 'StartupHub', 'Remote', 'Internship', 'Fresher', '15K/month', 'Internship for freshers');
