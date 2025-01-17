
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
    private CursoRepository modeloRepository;

    @Override 
    public List<Curso> findCursoAll() {
        List<Curso> responseCurso = new ArrayList<>();
        List<Curso> cursos= modeloRepository.findAll(); 
        
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
        // Verificar que el curso asociado existe
        if (curso.getInscripcion() == null || curso.getInscripcion().getIdInscripcion() == null) {
            throw new IllegalArgumentException("El curso asociado no puede ser nulo.");
        }

        Curso savedCurso = modeloRepository.save(curso);
        return savedCurso.getIdCurso();
    } catch (Exception e) {
        System.err.println("Error al crear: " + e.getMessage());
        return null;
    }
}
  

    @Override
    public Curso actualizaCurso(Curso cursoActualizar, Long idCurso) {
        Curso cursoEntity = new Curso();
        cursoEntity.setIdCurso(idCurso);
        cursoEntity.setNombre(cursoActualizar.getNombre());
        cursoEntity.setHoras(cursoActualizar.getHoras());

        Curso cursoSaved = modeloRepository.save(cursoEntity);
        Curso cursoActu = new Curso();
        cursoActu.setIdCurso(cursoSaved.getIdCurso());
        cursoActu.setNombre(cursoSaved.getNombre());
        cursoActu.setHoras(cursoSaved.getHoras());

        return cursoActu;
    }


    @Override
    public void eliminarCurso(Long idCurso) {
        if (modeloRepository.existsById(idCurso)) {
            modeloRepository.deleteById(idCurso); 
        }
    }
    
}
