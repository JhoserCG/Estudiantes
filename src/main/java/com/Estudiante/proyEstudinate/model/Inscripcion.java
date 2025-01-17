/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Estudiante.proyEstudinate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inscripcion {
    
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion; 

    private String mes;

    public Inscripcion() {
    }

    public Inscripcion(Long idInscripcion, String mes) {
        this.idInscripcion = idInscripcion;
        this.mes = mes;
    }

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

   
    
    
    
    
}  