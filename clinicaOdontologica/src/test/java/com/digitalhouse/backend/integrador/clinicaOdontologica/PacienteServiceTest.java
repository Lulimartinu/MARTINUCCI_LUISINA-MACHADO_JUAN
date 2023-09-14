package com.digitalhouse.backend.integrador.clinicaOdontologica;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PacienteServiceTest {
    @Autowired
    PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaCrearUnPacienteConDniIgualA51358032() {

        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Luisina", "Martinucci", 51358032, LocalDate.of(2023, 10, 25), new DomicilioEntradaDto("calle", 125, "florida", "florida"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(pacienteEntradaDto);

        assertEquals(51358032, pacienteSalidaDto.getDni());
    }

/*
   @Test
   @Order(2)
    void noDeberiaCrearUnPacienteConDniIgualA51358032(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan", "Machado", 51358032, LocalDate.of(2023, 12, 25), new DomicilioEntradaDto("lavalleja", 4587, "montevideo", "montevideo"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(pacienteEntradaDto);
        assertThrows(DataIntegrityViolationException.class, () -> {
            pacienteService.crearPaciente(pacienteEntradaDto);
        }) ;
    }
*/

  @Test
    @Order(2)
    void deberiaEliminarUnPacienteConIdIgualA1(){
      try {
          pacienteService.eliminarPacientePorId(1L);
      }
      catch (Exception e){
          e.printStackTrace();
      }
        assertNull(pacienteService.buscarPacientePorId(1L),"No se ha encontrado un Paciente en la BDD con el id1");

    }



    @Test
    @Order(3)
    void alIntentarEliminarUnPacienteYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
        try{
            pacienteService.eliminarPacientePorId(1L);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPacientePorId(1L));
    }
}


