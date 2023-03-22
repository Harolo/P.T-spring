package com.pruebaTecnica.Repository;

import com.pruebaTecnica.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

//    query que busca si exitse una persona con el nombre y el apellido enviados
    @Query(value = "SELECT * FROM persona p WHERE p.per_nombre=:nombre AND p.per_apellidos=:apellido",nativeQuery = true)
    Optional<PersonaEntity> findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);

    Optional<PersonaEntity> findById(Long id);
}
