package com.example.demo.dto;

import com.example.demo.model.Student;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;



public class StudentIn implements Serializable {
    @NotBlank @Length(min = 5, max = 30)
    private String fullName;

    @Min(100) @Max(800)
    private Integer psycoScore;

    @Min(30) @Max(100)
    private Double graduationScore;

    @NotBlank @Length(min = 10, max = 10)
    private String phone;

    public @NotBlank @Length(min = 5, max = 30) String getFullName() {
        return fullName;
    }

    public void setFullName(@NotBlank @Length(min = 5, max = 30) String fullName) {
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

    public @NotBlank @Length(min = 10, max = 10) String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank @Length(min = 10, max = 10) String phone) {
        this.phone = phone;
    }

    public Student toStudent(StudentIn studentIn) {
        return new Student(
                studentIn.getFullName(),
                studentIn.getPsycoScore(),
                studentIn.getGraduationScore(),
                studentIn.getPhone(),
                null
        );
    }

    public void updateStudent(Student student) {
        student.setFullName(fullName);
        student.setPsycoScore(psycoScore);
        student.setGraduationScore(graduationScore);
        student.setPhone(phone);
    }
}