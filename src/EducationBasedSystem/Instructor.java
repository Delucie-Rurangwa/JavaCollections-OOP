package EducationBasedSystem;

import java.util.Objects;

public class Instructor {
    private String name;
    private int id;
    private int age;
    private String email;
    private String gender;
    private int phoneNumber;
    private String department;

    public Instructor(String name, int id, int age, String email, String gender, int phoneNumber, String department) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }


}