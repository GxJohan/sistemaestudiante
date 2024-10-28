package com.example.sistemaestudiante.service;

import com.example.sistemaestudiante.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sistemaestudiante.repository.MatriculaRepository;
import com.example.sistemaestudiante.model.Matricula;
import com.example.sistemaestudiante.repository.StudentRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.time.LocalDate;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Matricula> getAllMatriculas() {
        return matriculaRepository.findAll();
    }

    public Matricula getMatriculaById(int id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public Matricula addMatricula(Matricula matricula) {
        Student student = studentRepository.findById(matricula.getStudent().getId()).orElse(null);
        if (student != null) {
            matricula.setStudent(student);
            matricula.setFechaMatricula(LocalDateTime.now());
        }

        return matriculaRepository.save(matricula);
    }

    public Matricula updateMatricula(int id, Matricula matricula) {
        Matricula mat = matriculaRepository.findById(id).orElse(null);
        Student student = studentRepository.findById(matricula.getStudent().getId()).orElse(null);
        if (mat != null && student != null ) {
            mat.setStudent(student);
            mat.setFechaMatricula(matricula.getFechaMatricula());
            return matriculaRepository.save(mat);
        }
        return null;
    }

    public void deleteMatricula(int id) {
        matriculaRepository.deleteById(id);
    }
}
