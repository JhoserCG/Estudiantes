/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Estudiante.proyEstudinate.service;

import com.Estudiante.proyEstudinate.model.Curso;
import java.util.List;

/**
 *
 * @author User
 */
public interface CursoService {
    
     List<Curso> findCursoAll();

    Long createCurso(Curso curso);

    Curso actualizaCurso(Curso cursoActualizar, Long idCurso);

    void eliminarCurso(Long idCurso);
}
