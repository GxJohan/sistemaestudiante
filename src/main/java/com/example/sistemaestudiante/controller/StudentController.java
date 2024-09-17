package com.example.sistemaestudiante.controller;

import com.example.sistemaestudiante.service.StudentService;
import com.example.sistemaestudiante.model.Student;
import com.example.sistemaestudiante.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Obtener la lista de todos los estudiantes registrados
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //Obtener un estudiante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student!=null){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

}
