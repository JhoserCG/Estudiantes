
package com.Estudiante.proyEstudinate.service.impl;

import com.Estudiante.proyEstudinate.model.Inscripcion;
import com.Estudiante.proyEstudinate.repository.InscripcionRepository;
import com.Estudiante.proyEstudinate.service.InscripcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionServiceimpl implements InscripcionService{
    @Autowired
	    private InscripcionRepository inscripcionRepository;
	
	    @Override
	    public List<Inscripcion> findInscripcionAll() {
	        return inscripcionRepository.findAll();
	    }
	
	    
	    public Long createInscripcion(Inscripcion inscripcion) {
	        try {
	            Inscripcion savedInscripcion = inscripcionRepository.save(inscripcion);
	            return savedInscripcion.getIdInscripcion();
	        } catch (Exception e) {
	            System.out.println("Error al crear vehículo: " + e.getMessage());
	            return null;
	        }
	    }
	
	    
	    public Inscripcion actualizaInscripcion(Inscripcion inscripcionActualizar, Long idInscripcion) {
	        try {
	            if (inscripcionRepository.existsById(idInscripcion)) {
	                inscripcionActualizar.setIdInscripcion(idInscripcion);
	                return inscripcionRepository.save(inscripcionActualizar);
	            }
	            return null;
	        } catch (Exception e) {
	            System.out.println("Error al actualizar vehículo: " + e.getMessage());
	            return null;
	        }
	    }
	
	    
	    public void eliminarInscripcion(Long idInscripcion) {
	        try {
	            if (inscripcionRepository.existsById(idInscripcion)) {
	                inscripcionRepository.deleteById(idInscripcion);
	            }
	        } catch (Exception e) {
	            System.out.println("Error al eliminar vehículo: " + e.getMessage());
	        }
	    }

    
}
