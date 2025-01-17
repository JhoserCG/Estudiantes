/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Estudiante.proyEstudinate.service;

import com.Estudiante.proyEstudinate.model.Inscripcion;
import java.util.List;

/**
 *
 * @author User
 */
public interface InscripcionService {
    List<Inscripcion> findInscripcionAll();

    Long createInscripcion(Inscripcion inscripcion);

    Inscripcion actualizaInscripcion(Inscripcion inscripcionActualizar, Long idInscripcion);

    void eliminarInscripcion(Long idInscripcion);
}
