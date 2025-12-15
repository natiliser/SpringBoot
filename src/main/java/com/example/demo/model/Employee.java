package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Length(max = 30)
    private String fullName;

    @Min(0)
    @Max(70)
    private Integer age;

    @Min(0)
    @Max(100)
    private Double grade;

    @Length(max = 10)
    private String phone;

    @Length(max = 500)
    private String profilePicture;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 chars, with letters and numbers")
    private String password;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Future(message = "Goal target date must be in the future")
    private LocalDate targetDate;
}
