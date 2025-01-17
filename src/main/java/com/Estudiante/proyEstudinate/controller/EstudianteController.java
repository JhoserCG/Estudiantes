/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Estudiante.proyEstudinate.controller;

import com.Estudiante.proyEstudinate.model.Estudiante;
import com.Estudiante.proyEstudinate.service.EstudianteService;
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
@RequestMapping("/v1/estudiantes")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;


    @GetMapping
    public List<Estudiante> findAllEstudiante() {
        return estudianteService.findEstudianteAll();
    }


    @PostMapping("/create")
    public Long createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.createEstudiante(estudiante);
    }
    @PutMapping("/update/{id}")
    public Estudiante updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return estudianteService.actualizarEstudiante(estudiante, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
    }
}
