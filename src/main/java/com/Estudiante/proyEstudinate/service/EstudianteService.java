/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Estudiante.proyEstudinate.service;

import com.Estudiante.proyEstudinate.model.Estudiante;
import java.util.List;

/**
 *
 * @author User
 */
public interface EstudianteService {
    
    List<Estudiante> findEstudianteAll();

    Long createEstudiante(Estudiante estudiante);

   Estudiante actualizarEstudiante(Estudiante estudianteActualizar, Long idEstudiante);

    void eliminarEstudiante(Long idEstudiante);
}
