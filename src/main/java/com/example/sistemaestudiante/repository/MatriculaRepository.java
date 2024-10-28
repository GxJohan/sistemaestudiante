package com.example.sistemaestudiante.repository;

import com.example.sistemaestudiante.model.Matricula;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

}
