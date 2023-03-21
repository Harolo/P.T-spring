package com.pruebaTecnica.Service;

import com.pruebaTecnica.Dto.PersonaDto;
import com.pruebaTecnica.Entity.PersonaEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    ResponseEntity<String> guardarPersona(PersonaDto persona);
    ResponseEntity<String> editarPersona(PersonaDto persona,Long id);
    List<PersonaEntity> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<String> eliminarPersona(Long id);

}
