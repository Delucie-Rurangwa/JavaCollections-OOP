package EducationBasedSystem;

import java.util.Objects;


public class Course {
    private String courseName;
    private String courseId;
    private double credit;
    private Instructor instructor;

    public Course(String courseName, String courseId, double credit, Instructor instructor) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.credit = credit;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}