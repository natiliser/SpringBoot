package com.example.demo.service;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public Iterable<Student> all() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Student student) {
        repository.delete(student);
    }

    public Optional<Student> findByFullName(String fullName) {
        return repository.findByFullName(fullName);
    }

    public Optional<Student> findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Optional<Student> findFirstByGraduationScore(double graduationScore) {
        return repository.findFirstByGraduationScore(graduationScore);
    }

}