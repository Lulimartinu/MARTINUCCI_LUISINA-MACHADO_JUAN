package com.digitalhouse.backend.integrador.clinicaOdontologica;


import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.DomicilioEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.OdontologoService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.PacienteService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.TurnoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.management.BadAttributeValueExpException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TurnoServiceTest {
    @Autowired
    PacienteService pacienteService;
    OdontologoService odontologoService;
    TurnoService turnoService;

    /* @Test
     @Order(1)
     void deberiaCrearUnTurnoConId1() throws BadRequestException {


         PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Luisina", "Martinucci", 51358032, LocalDate.of(2023, 10, 25), new DomicilioEntradaDto("calle", 125, "florida", "florida"));

         PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(pacienteEntradaDto);


         OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AA-123456789","Luciana","Murga");

         OdontologoSalidaDto odontologoSalidaDto = odontologoService.crearOdontologo(odontologoEntradaDto);


         TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L,1L, LocalDateTime.of(2023,12,25,15,00));

         TurnoSalidaDto turnoSalidaDto = turnoService.crearTurno(turnoEntradaDto);

         assertEquals(1,turnoSalidaDto.getId());
     }
 */

}
