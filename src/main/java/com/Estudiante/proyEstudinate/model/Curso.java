/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Estudiante.proyEstudinate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
	private String nombre;
	private int horas;

    public Curso() {
    }

    public Curso(Long idCurso, String nombre, int horas) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.horas = horas;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
        
        @ManyToOne(optional = false)
        @JoinColumn(name = "idInscripcion")
        private Inscripcion inscripcion;
         public Inscripcion getInscripcion(){
             return inscripcion;
         }
         public void setInscripcion(Inscripcion inscripcion){
             this.inscripcion = inscripcion;
         }
}
