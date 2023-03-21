package com.pruebaTecnica.Dto.Interfaces;

import java.time.LocalDate;

public interface PersonaInterFace {
    Long getId();
    String getNombre();
    String getApellido();
    LocalDate getFechaNacimiento();
    byte[] getFoto();
    String getEstadoCivil();
    boolean getHermanos();
}
