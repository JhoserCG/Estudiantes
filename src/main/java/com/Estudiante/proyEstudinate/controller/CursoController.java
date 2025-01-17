/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Estudiante.proyEstudinate.controller;

import com.Estudiante.proyEstudinate.model.Curso;
import com.Estudiante.proyEstudinate.service.CursoService;
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
@RequestMapping("/v1/cursos")
public class CursoController {
    
     @Autowired
    private CursoService cursoService;

    @GetMapping("/ver")
    public List<Curso> findAllCurso() {
        return cursoService.findCursoAll();
    }


    @PostMapping("/create")
    public Long createCurso(@RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }
    @PutMapping("/update/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizaCurso(curso, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
    
}
