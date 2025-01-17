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
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idEstudiante;
        private String nombre;
	private String apellido;
        private int dni;

    public Estudiante() {
    }

    public Estudiante(Long idEstudiante, String nombre, String apellido, int dni, Inscripcion inscripcion) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.inscripcion = inscripcion;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
