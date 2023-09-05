package com.digitalhouse.backend.integrador.clinicaOdontologica.repository;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontoRepository extends JpaRepository<Odontologo,Long> {


}
