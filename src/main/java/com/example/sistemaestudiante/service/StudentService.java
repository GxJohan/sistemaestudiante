package com.example.sistemaestudiante.service;

import com.example.sistemaestudiante.model.Student;
import com.example.sistemaestudiante.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student) {
        Student stud = studentRepository.findById(id).orElse(null);
        if (stud != null) {
            stud.setName(student.getName());
            stud.setEmail(student.getEmail());
            return studentRepository.save(stud);
        }
        return null;
    }
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }






}
