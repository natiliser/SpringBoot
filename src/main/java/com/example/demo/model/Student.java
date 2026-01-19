package com.example.demo.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity @Table(name="student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Length(max = 30)
    private String fullName;

    @Min(100)
    @Max(800)
    private Integer psycoScore;

    @Min(30)
    @Max(100)
    private Double graduationScore;

    @Length(max = 10)
    private String phone;

    @Length(max = 500)
    private String profilePicture;

    public Student(){
    }

    public @NotEmpty @Length(max = 30) String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty @Length(max = 30) String fullName) {
        this.fullName = fullName;
    }

    public @Min(100) @Max(800) Integer getPsycoScore() {
        return psycoScore;
    }

    public void setPsycoScore(@Min(100) @Max(800) Integer psycoScore) {
        this.psycoScore = psycoScore;
    }

    public @Min(30) @Max(100) Double getGraduationScore() {
        return graduationScore;
    }

    public void setGraduationScore(@Min(30) @Max(100) Double graduationScore) {
        this.graduationScore = graduationScore;
    }

    public @Length(max = 10) String getPhone() {
        return phone;
    }

    public void setPhone(@Length(max = 10) String phone) {
        this.phone = phone;
    }

    public @Length(max = 500) String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(@Length(max = 500) String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Student(String fullName, Integer psycoScore, Double graduationScore, String phone, String profilePicture) {
        this.fullName = fullName;
        this.psycoScore = psycoScore;
        this.graduationScore = graduationScore;
        this.phone = phone;
        this.profilePicture = profilePicture;
    }
}