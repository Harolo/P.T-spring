package com.pruebaTecnica.Controller;

import com.pruebaTecnica.Dto.PersonaDto;
import com.pruebaTecnica.Entity.PersonaEntity;
import com.pruebaTecnica.Service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping(value = "/registrar")
    private ResponseEntity<String> guardaPersona(@Valid @RequestBody PersonaDto persona){
        return personaService.guardarPersona(persona);
    }

    @GetMapping(value ="/listarTodo")
    private List<PersonaEntity> listarTodo(){
       return personaService.findAll();
    }

    @GetMapping(value ="/listar/{id}")
    private ResponseEntity<?> listarById(@PathVariable Long id){
        return personaService.findById(id);
    }

    @PutMapping(value = "/editar/{id}")
    private ResponseEntity<String> editarPersona(@RequestBody @Valid PersonaDto personaDto, @PathVariable Long id ){
        return personaService.editarPersona(personaDto,id);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    private ResponseEntity<String> elimiarPersona(@PathVariable Long id){
        return personaService.eliminarPersona(id);
    }

}
