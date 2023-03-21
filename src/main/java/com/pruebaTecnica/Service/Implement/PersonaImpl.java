package com.pruebaTecnica.Service.Implement;

import com.pruebaTecnica.Dto.Interfaces.PersonaInterFace;
import com.pruebaTecnica.Dto.PersonaDto;
import com.pruebaTecnica.Entity.PersonaEntity;
import com.pruebaTecnica.Repository.PersonaRepository;
import com.pruebaTecnica.Service.PersonaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaImpl implements PersonaService {
    private final PersonaRepository personaRepository;
    private final ModelMapper modelMapper;

    public PersonaImpl(PersonaRepository personaRepository, ModelMapper modelMapper) {
        this.personaRepository = personaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<String> guardarPersona(PersonaDto persona) {
        try {
            Optional<PersonaEntity> per = personaRepository.findByNombreAndApellido(persona.getNombre(), persona.getApellido());
            if (per.isPresent()) {
                return ResponseEntity.badRequest().body("Persona ya existe");
            } else {
                personaRepository.save(modelMapper.map(persona, PersonaEntity.class));
                return ResponseEntity.ok().body("Persona guardada con exito");
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar persona" + e);
        }

    }

    @Override
    public ResponseEntity<String> editarPersona(PersonaDto persona, Long id) {
        try {
            Optional<PersonaEntity> per = personaRepository.findById(id);
            if (per.isPresent()) {
                PersonaEntity personaEntity = per.get();
                personaEntity.setNombre(persona.getNombre());
                personaEntity.setApellido(persona.getApellido());
                personaEntity.setEstadoCivil(persona.getEstadoCivil());
                personaEntity.setFechaNacimiento(persona.getFechaNacimiento());
                personaEntity.setFoto(persona.getFoto());
                personaEntity.setHermanos(persona.isHermanos());
                personaRepository.save(personaEntity);
                return ResponseEntity.ok().body("Datos actualizados correctamente");

            } else {
                return ResponseEntity.badRequest().body("Persona no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar los datos");
        }

    }

    @Override
    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        try {
            Optional<PersonaEntity> persona = personaRepository.findById(id);
            if (persona.isPresent()) {
                return ResponseEntity.ok().body(modelMapper.map(persona, PersonaDto.class));
            } else {
                return ResponseEntity.badRequest().body("la persona no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al ejecutar la conulta");

        }
    }

    @Override
    public ResponseEntity<String> eliminarPersona(Long id) {
        try {
            Optional<PersonaEntity> persona = personaRepository.findById(id);
            if (persona.isPresent()) {
                PersonaEntity per = persona.get();
                personaRepository.delete(per);
                return ResponseEntity.ok().body("Persona eliminada correctamente");
            } else {
                return ResponseEntity.ok().body("Persona no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body("Error al eliminar la persona " + e);
        }
    }
}
