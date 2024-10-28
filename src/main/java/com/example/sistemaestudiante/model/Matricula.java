package com.example.sistemaestudiante.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "matricula")
public class Matricula {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @Column(name = "student_id")
        private Student student;

        @Column(name = "fecha_matricula")
        private LocalDateTime fechaMatricula;


}
