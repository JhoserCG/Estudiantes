/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Estudiante.proyEstudinate.repository;

import com.Estudiante.proyEstudinate.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}