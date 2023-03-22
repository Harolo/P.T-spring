package com.pruebaTecnica.Dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PersonaDto implements Serializable {

    @NotNull(message = "nombre no debe estar vacio")
    @Size(max = 20, message = "el nombre no puede ser mayor a 20 caracteres")
    @Size(min = 5, message = "el nombre no puede ser menor a 5 caracteres")
    private String nombre;

    @NotNull(message = "apellidos no debe estar vacio")
    @Size(max = 20, message = "el apellido no puede ser mayor a 20 caracteres")
    @Size(min = 5, message = "el apellido no puede ser menor a 5 caracteres")
    private String apellido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "la fecha no puede estar vacia")
    private LocalDate fechaNacimiento;

    @NotNull(message = "la foto no puede estar vacia")
    private  byte[] foto;

    @Size(max = 11, message = "el estado civil no puede ser mayor a 11 caracteres")
    @Size(min = 5, message = "el estado civil no puede ser menor a 5 caracteres")
    private String estadoCivil;

    @NotNull(message = "hermanos no puede estar vacio")
    @AssertTrue(message = "hermanos no puede estar vacio")
    private boolean hermanos;
}
