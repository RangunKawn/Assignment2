package com.myprofileAdam;

import java.io.Serializable;

public class ProfileBean implements Serializable {
    
    
    private String name;
    private String studentID;
    private String program;
    private String email;
    private String hobbies;
    private String intro;

    // Default constructor
    public ProfileBean() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHobbies() { return hobbies; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }

    public String getIntro() { return intro; }
    public void setIntro(String intro) { this.intro = intro; }
}