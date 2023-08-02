CREATE TABLE IF NOT EXISTS persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    last_name VARCHAR(255),
    age INT,
    occupation VARCHAR(255)
);

INSERT INTO persons (name, last_name, age, occupation) VALUES 
('John', 'Doe', 30, 'Software Engineer'),
('Jane', 'Doe', 28, 'Data Scientist'),
('Alice', 'Johnson', 35, 'Product Manager'),
('Bob', 'Smith', 40, 'DevOps Engineer'),
('Charlie', 'Brown', 25, 'Web Developer'),
('Dave', 'Miller', 45, 'Database Administrator'),
('Eve', 'Davis', 32, 'UX Designer'),
('Frank', 'Taylor', 50, 'CTO'),
('Grace', 'Wilson', 38, 'Scrum Master'),
('Helen', 'Moore', 27, 'QA Engineer');

CREATE TABLE lecture (
    lecture_id SERIAL PRIMARY KEY,
    person_id INT,
    lecture_name VARCHAR(100),
    credits INT,
    FOREIGN KEY (person_id) REFERENCES persons (id)
);

INSERT INTO lecture (person_id, lecture_name, credits)
VALUES (1, 'Physics 101', 3),
       (2, 'Chemistry 101', 4),
       (3, 'Mathematics 101', 3),
       (4, 'Biology 101', 4),
       (5, 'English Literature 101', 3),
       (6, 'Computer Science 101', 4),
       (7, 'Data Science 101', 4),
       (8, 'Architecture 101', 3),
       (9, 'Art History 101', 2),
       (10, 'Project Management 101', 4);