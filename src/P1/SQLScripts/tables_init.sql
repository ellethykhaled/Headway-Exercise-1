-- Creation of students table
CREATE TABLE students (
    id INT NOT NULL,
    name VARCHAR(50) DEFAULT NULL,
    age INT DEFAULT NULL,
    grade FLOAT DEFAULT NULL,
    faculty_serial_number INT NOT NULL,

    CONSTRAINT pk_Students PRIMARY KEY (id),
    CONSTRAINT uc_Students_faculty_serial_number UNIQUE (faculty_serial_number)
);

-- Creation of departments table
CREATE TABLE departments (
    id INT NOT NULL,
    name VARCHAR(50) DEFAULT NULL,
    boss VARCHAR(50) DEFAULT NULL,
    
    CONSTRAINT pk_Departments PRIMARY KEY (id)
);

-- Creation of the joining table between students table and departments table
CREATE TABLE students_departments (
    student_id INT,
    department_id INT,

    CONSTRAINT stud_dep_pk PRIMARY KEY (student_id, department_id)
);

-- Adding the foreign key constraints
ALTER TABLE students_departments ADD CONSTRAINT fk_students_departments_student_id FOREIGN KEY(student_id)
REFERENCES students (id);

ALTER TABLE students_departments ADD CONSTRAINT fk_students_departments_department_id FOREIGN KEY(department_id)
REFERENCES departments (id);