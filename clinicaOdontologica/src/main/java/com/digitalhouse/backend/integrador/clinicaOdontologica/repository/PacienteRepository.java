package com.digitalhouse.backend.integrador.clinicaOdontologica.repository;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
