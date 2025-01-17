
package com.Estudiante.proyEstudinate.service.impl;

import com.Estudiante.proyEstudinate.model.Estudiante;
import com.Estudiante.proyEstudinate.repository.EstudianteRepository;
import com.Estudiante.proyEstudinate.service.EstudianteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceimpl implements EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Override
    public List<Estudiante> findEstudianteAll() {
        return estudianteRepository.findAll();
    }

    @Override
public Long createEstudiante(Estudiante estudiante) {
    try {
        // Verificar que el vehículo asociado existe
        if (estudiante.getInscripcion() == null || estudiante.getInscripcion().getIdInscripcion() == null) {
            throw new IllegalArgumentException("El vehículo asociado no puede ser nulo.");
        }

        Estudiante savedEstudiante = estudianteRepository.save(estudiante);
        return savedEstudiante.getIdEstudiante();
    } catch (Exception e) {
        System.err.println("Error al crear venta: " + e.getMessage());
        return null;
    }
}

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudianteActualizar, Long idEstudiante) {
        try {
            Optional<Estudiante> estudianteExistente = estudianteRepository.findById(idEstudiante); 
            if (estudianteExistente.isPresent()) {
                estudianteActualizar.setIdEstudiante(idEstudiante); 
                return estudianteRepository.save(estudianteActualizar); 
            } else {
                System.err.println("Venta con ID " + idEstudiante + " no encontrada."); 
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar venta: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public void eliminarEstudiante(Long idEstudiante) {
        try {
            Optional<Estudiante> estudianteExistente = estudianteRepository.findById(idEstudiante);
            if (estudianteExistente.isPresent()) {
                estudianteRepository.deleteById(idEstudiante); 
            } else {
                System.err.println("Venta con ID " + idEstudiante + " no encontrada."); 
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar venta: " + e.getMessage());
        }
    }
}
