# Student Record System

A Java-based student management system that allows you to register, track, and analyze student grades and academic performance.

## Overview

The Student Record System is a console-based application designed to manage student records efficiently. It supports two types of students (Regular and Scholarship) and provides comprehensive statistics and search functionality.

## Features

- **Register Students**: Add new students with their name, age, grade, and type (Regular or Scholarship)
- **View Grades**: Display all registered students sorted by grade in descending order
- **View Statistics**: Get comprehensive class statistics including:
  - Total number of students
  - Average grade
  - Highest and lowest grades
  - Number of students who passed/failed
- **Search Students**: Find a specific student by name and view their details
- **Grade Validation**: Ensures grades are between 0.0 and 10.0
- **Duplicate Prevention**: Prevents registering students with duplicate names

## Project Structure

```
src/
├── Main.java                 # Main application with menu system and utility methods
├── Person.java              # Base class for all persons (name, age)
├── Student.java             # Student class extending Person (grade, status)
├── RegularStudent.java       # Regular student type
└── ScholarshipStudent.java   # Scholarship student type
```

## Class Hierarchy

```
Person (base class)
  └── Student
      ├── RegularStudent
      └── ScholarshipStudent
```

## Classes

### Person
Base class containing basic information about a person.

**Fields:**
- `name: String` - Person's name
- `age: int` - Person's age

**Methods:**
- `getName()` - Returns the person's name
- `getAge()` - Returns the person's age
- `setName(String name)` - Sets the person's name
- `setAge(int age)` - Sets the person's age

### Student
Extends Person and adds academic information.

**Fields:**
- `grade: double` - Student's grade (0.0 - 10.0)

**Methods:**
- `getGrade()` - Returns the student's grade
- `setGrade(double grade)` - Sets the student's grade
- `getStatus()` - Returns "Passed" (grade >= 6.0) or "Failed"
- `getType()` - Returns the student type
- `displayInfo()` - Displays student name and grade
- `displayInfo(boolean showStatus)` - Displays student info with optional status

### RegularStudent
Represents a regular student (extends Student).

**Methods:**
- `getType()` - Returns "Regular"

### ScholarshipStudent
Represents a scholarship student (extends Student).

**Methods:**
- `getType()` - Returns "Scholarship"

### Main
Contains the application logic and utility methods.

**Main Methods:**
- `main(String[] args)` - Entry point and main menu loop
- `printMenu()` - Displays the menu options
- `registerStudent(Scanner scanner)` - Registers a new student
- `viewGrades()` - Shows all students sorted by grade
- `viewStatistics()` - Displays class statistics
- `searchStudent(Scanner scanner)` - Searches for a student

**Utility Methods:**
- `calculateAverage(double[] grades)` - Calculates average grade
- `highestGrade(double[] grades)` - Finds the highest grade
- `lowestGrade(double[] grades)` - Finds the lowest grade
- `countPassed(double[] grades)` - Counts students who passed
- `getStatus(double grade)` - Returns pass/fail status
- `sumGrades(double[] grades, int i)` - Recursively sums grades
- `toArray(ArrayList<Double> list)` - Converts ArrayList to array

## How to Use

### Compilation
```bash
javac *.java
```

### Running the Application
```bash
java Main
```

### Menu Options

1. **Register students** - Add a new student to the system
2. **View grades** - See all students with their grades (sorted highest to lowest)
3. **View statistics** - Get class statistics (average, min, max, pass/fail counts)
4. **Search student** - Find a student by name
5. **Exit** - Close the application

### Example Usage

1. Run the program: `java Main`
2. Select option 1 to register a student
3. Enter student details when prompted
4. View grades, statistics, or search as needed
5. Select option 5 to exit

## Grading Scale

- **Passing Grade**: 6.0 or higher
- **Failing Grade**: Below 6.0
- **Valid Range**: 0.0 to 10.0

## Data Structures Used

- `ArrayList<String> names` - Stores student names
- `ArrayList<Double> gradeList` - Stores all grades
- `HashMap<String, Double> gradeMap` - Maps student names to grades
- `ArrayList<Student> students` - Stores Student objects

## Technical Details

- **Language**: Java
- **Type**: Console Application
- **Input**: Scanner (user input from console)
- **Output**: Formatted console output
- **Data Persistence**: In-memory (data is lost when application exits)

## Future Enhancements

- [ ] File-based data persistence (save/load from files)
- [ ] Database integration
- [ ] GUI implementation
- [ ] Grade modification functionality
- [ ] Student deletion/update features
- [ ] Export grades to CSV/PDF
- [ ] Advanced filtering and sorting options

## Notes

- Grades must be between 0.0 and 10.0
- Student names must be unique
- The passing grade threshold is 6.0
- All data is stored in memory and lost when the program exits