package com.pruebaTecnica.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "per_nombre")
    private String nombre;

    @Column(name = "per_apellidos")
    private String apellido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "per_fecha_nacimiento")
    private LocalDate fechaNacimiento;


    @Column(name = "per_foto")
    private byte[] foto;

    @Column(name = "per_estado_civil")
    private String estadoCivil;

    @Column(name = "per_hermanos")
    private boolean hermanos;

}
