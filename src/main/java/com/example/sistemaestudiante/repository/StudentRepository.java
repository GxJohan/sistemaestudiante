package com.example.sistemaestudiante.repository;

import com.example.sistemaestudiante.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository {
    public Student findById(int id);
}
