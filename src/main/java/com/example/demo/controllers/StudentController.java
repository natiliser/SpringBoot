package com.example.demo.controllers;

import com.example.demo.dto.StudentIn;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudents() {
        return new ResponseEntity<>(studentService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insertStudent(@RequestBody StudentIn studentIn) {
        Student student = studentIn.toStudent(studentIn);
        student = studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentIn studentIn) {
        Optional<Student> dbStudent = studentService.findById(id);
        studentIn.updateStudent(dbStudent.get());
        Student updatedStudent = studentService.save(dbStudent.get());
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        Optional<Student> dbStudent = studentService.findById(id);
        studentService.delete(dbStudent.get());
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name) {
        return new ResponseEntity<>(studentService.findByFullName(name), HttpStatus.OK);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getStudentByPhone(@PathVariable String phone) {
        return new ResponseEntity<>(studentService.findByPhone(phone), HttpStatus.OK);
    }

    @GetMapping("/GraduationScore/{GraduationScore}")
    public ResponseEntity<Optional<Student>> getStudentByScore(@PathVariable double GraduationScore) {
        return new ResponseEntity<>(studentService.findFirstByGraduationScore(GraduationScore), HttpStatus.OK);
    }

}

