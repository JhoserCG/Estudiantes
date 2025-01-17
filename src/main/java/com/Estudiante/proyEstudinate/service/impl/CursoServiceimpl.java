
package com.Estudiante.proyEstudinate.service.impl;

import com.Estudiante.proyEstudinate.model.Curso;
import com.Estudiante.proyEstudinate.repository.CursoRepository;
import com.Estudiante.proyEstudinate.service.CursoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceimpl implements CursoService{

 @Autowired
    private CursoRepository cursoRepository;

    @Override 
    public List<Curso> findCursoAll() {
        List<Curso> responseCurso = new ArrayList<>();
        List<Curso> cursos= cursoRepository.findAll(); 
        
        for (Curso curso : cursos) {
        	
            Curso cursoResponse = new Curso();
            cursoResponse.setIdCurso(curso.getIdCurso()); 
            cursoResponse.setNombre(curso.getNombre());     
            cursoResponse.setHoras(curso.getHoras());      
            
            responseCurso.add(cursoResponse);  
        }
        
        return responseCurso;  
    }

    @Override
    public Long createCurso(Curso curso) {
    try {
        // Verificar que el vehículo asociado existe
        if (curso.getInscripcion() == null || curso.getInscripcion().getIdInscripcion() == null) {
            throw new IllegalArgumentException("El vehículo asociado no puede ser nulo.");
        }

        Curso savedCurso = cursoRepository.save(curso);
        return savedCurso.getIdCurso();
    } catch (Exception e) {
        System.err.println("Error al crear venta: " + e.getMessage());
        return null;
    }
} 

    @Override
public Curso actualizaCurso(Curso cursoActualizar, Long idCurso) {
    // Busca el curso existente en la base de datos
    Curso cursoExistente = cursoRepository.findById(idCurso)
            .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con el id: " + idCurso));

    // Actualiza los campos del curso existente
    cursoExistente.setNombre(cursoActualizar.getNombre());
    cursoExistente.setHoras(cursoActualizar.getHoras());

    // Si curso tiene relación con Inscripcion, actualiza la inscripción
    if (cursoActualizar.getInscripcion() != null) {
        cursoExistente.setInscripcion(cursoActualizar.getInscripcion());
    }

    // Guarda y devuelve el curso actualizado
    return cursoRepository.save(cursoExistente);
}



    @Override
    public void eliminarCurso(Long idCurso) {
        if (cursoRepository.existsById(idCurso)) {
            cursoRepository.deleteById(idCurso); 
        }
    }
    
}
