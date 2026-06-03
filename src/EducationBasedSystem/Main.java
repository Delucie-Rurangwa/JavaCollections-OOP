package EducationBasedSystem;

public class Main {
    public static void main(String[] args) {
        EducationSystem system = new EducationSystem();

        // 1. Register a student
        system.registerStudent(501, "Alice");

        // Test guardrail: Try to register the same ID again
        system.registerStudent(501, "Imposter");

        // 2. Enroll in courses
        system.enrollStudent(501, "Java Programming");
        system.enrollStudent(501, "Math 101");

        // Test guardrail: Try to enroll in Java again
        system.enrollStudent(501, "Java Programming");

        // 3. Assign Grades
        system.assignGrade(501, "Java Programming", 85.5);

        // Test guardrail: Try to grade a class she isn't taking
        system.assignGrade(501, "History", 90.0);

        // 4. Print the final result
        system.printSummary(501);
    }
}