/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Estudiante.proyEstudinate.controller;

import com.Estudiante.proyEstudinate.model.Inscripcion;
import com.Estudiante.proyEstudinate.service.InscripcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/inscripcion")
public class InscripcionController {
    
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("/ver")
    public List<Inscripcion> findAllInscripcion() {
        return inscripcionService.findInscripcionAll();
    }

    @PostMapping("/create")
    public Long createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.createInscripcion(inscripcion);
    }
    @PutMapping("/update/{id}")
    public Inscripcion updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.actualizaInscripcion(inscripcion, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteVehiculo(@PathVariable Long id) {
        inscripcionService.eliminarInscripcion(id);
    }
}
