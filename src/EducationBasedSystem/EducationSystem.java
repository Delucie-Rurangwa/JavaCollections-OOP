package EducationBasedSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EducationSystem {

    // 1. Store Students by ID -> Name
    private Map<Integer, String> studentNames = new HashMap<>();

    // 2. Store which courses a student takes by ID -> List of Course Names
    private Map<Integer, List<String>> studentCourses = new HashMap<>();

    // 3. Store grades using a unique text key (e.g., "501-Java") -> Grade
    private Map<String, Double> studentGrades = new HashMap<>();

      // REGISTER STUDENT
    public void registerStudent(int studentId, String name) {
        // Prevent duplicates
        if (studentNames.containsKey(studentId)) {
            System.out.println("Error: Student ID " + studentId + " is already taken.");
        } else {
            studentNames.put(studentId, name);
            // Give them an empty list of courses to start with
            studentCourses.put(studentId, new ArrayList<>());
            System.out.println("Success: " + name + " has been registered.");
        }
    }

    //  ENROLL IN COURSE
    public void enrollStudent(int studentId, String courseName) {
        // Check if student exists
        if (!studentNames.containsKey(studentId)) {
            System.out.println("Error: Cannot enroll. Student ID not found.");
            return;
        }

        // Get the list of courses for this student
        List<String> myCourses = studentCourses.get(studentId);

        // Prevent double enrollment
        if (myCourses.contains(courseName)) {
            System.out.println("Error: Student is already enrolled in " + courseName);
        } else {
            myCourses.add(courseName);
            System.out.println("Success: Student enrolled in " + courseName);
        }
    }

    //  ASSIGN GRADE
    public void assignGrade(int studentId, String courseName, double grade) {
        // Check grade limits
        if (grade < 0.0 || grade > 100.0) {
            System.out.println("Error: Grade must be between 0 and 100.");
            return;
        }

        // Check if student exists
        if (!studentNames.containsKey(studentId)) {
            System.out.println("Error: Student ID not found.");
            return;
        }

        List<String> myCourses = studentCourses.get(studentId);

        // Check if they are taking the class before grading
        if (!myCourses.contains(courseName)) {
            System.out.println("Error: Cannot assign grade. Student is not enrolled in " + courseName);
            return;
        }

        // Create a unique key for the grade map (Example: "501-Java")
        String gradeKey = studentId + "-" + courseName;
        studentGrades.put(gradeKey, grade);

        System.out.println("Success: Assigned " + grade + " for " + courseName);
    }

    //  PRINT SUMMARY
    public void printSummary(int studentId) {
        if (!studentNames.containsKey(studentId)) {
            System.out.println("Student not found.");
            return;
        }

        String name = studentNames.get(studentId);
        List<String> myCourses = studentCourses.get(studentId);

        System.out.println("\n--- Report Card for " + name + " ---");

        if (myCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (String course : myCourses) {
            String gradeKey = studentId + "-" + course;

            // Check if a grade exists for this class
            if (studentGrades.containsKey(gradeKey)) {
                System.out.println("Course: " + course + " | Grade: " + studentGrades.get(gradeKey));
            } else {
                System.out.println("Course: " + course + " | Grade: Not yet graded");
            }
        }
        System.out.println("---------------------------------");
    }
}