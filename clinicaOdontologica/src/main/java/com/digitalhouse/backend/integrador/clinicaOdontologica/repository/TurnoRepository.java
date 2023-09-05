package com.digitalhouse.backend.integrador.clinicaOdontologica.repository;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {


}
