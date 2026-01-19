package com.example.demo.repo;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> {

    public Optional<Student> findByFullName(String fullName);
    public Optional<Student> findByPhone(String phone);
    public Optional<Student> findFirstByGraduationScore(double graduationScore);
}