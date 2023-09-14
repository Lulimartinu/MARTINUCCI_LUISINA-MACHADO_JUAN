package com.digitalhouse.backend.integrador.clinicaOdontologica;

import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class TurnoServiceTest {
    @Autowired
    TurnoService turnoService;



}
