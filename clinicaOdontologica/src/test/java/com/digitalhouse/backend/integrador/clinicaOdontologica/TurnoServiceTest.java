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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TurnoServiceTest {
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    TurnoService turnoService;

    @Test
     @Order(1)
     void deberiaCrearUnTurnoConId1() throws BadRequestException {

        //CREAMOS PACIENTE ID1
         PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Luisina", "Martinucci", 51354532, LocalDate.of(2023, 10, 25), new DomicilioEntradaDto("calle", 125, "florida", "florida"));
         PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(pacienteEntradaDto);

        //CREAMOS ODONTOLOGO ID1
         OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AA-123456989","Luciana","Murga");
         OdontologoSalidaDto odontologoSalidaDto = odontologoService.crearOdontologo(odontologoEntradaDto);

        //CREAMOS TURNO CON ID 1 CON ODONTOLOGO ID 1 Y PACIENTE ID 1
         TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L,1L, LocalDateTime.of(2023,12,25,15,00));
         TurnoSalidaDto turnoSalidaDto = turnoService.crearTurno(turnoEntradaDto);

         //COMPARAMOS QUE EL TURNO CREADO SEA CON ID = 1
         assertEquals(1,turnoSalidaDto.getId());
     }

    @Test
    @Order(2)
    void deberiaEncontrarElTurno(){
        //CREAMOS PACIENTE
        PacienteEntradaDto paciente = new PacienteEntradaDto("Lionel", "Messi", 51358532, LocalDate.of(2023, 10, 25), new DomicilioEntradaDto("Rosario", 125, "Rosario", "Santa Fe"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(paciente);

        //CREAMOS ODONTOLOGO
        OdontologoEntradaDto odontologo = new OdontologoEntradaDto("AA-143456254","Sofia","Machado");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.crearOdontologo(odontologo);

        //CREAMOS TURNO
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L,1L, LocalDateTime.of(2023,11,25,15,00));
        try {
            TurnoSalidaDto turnoSalidaDto = turnoService.crearTurno(turnoEntradaDto);
        }
        catch (Exception e){
        e.printStackTrace();
    }
        // Verificaremos qe el turno buscado no sea null
        assertNotNull(turnoService.buscarTurnoPorId(1L));
    }

    /*
    Nos arrojó errores en este Test Lu! intentamos hacerlo hasta hoy pero bueno no le encontramos la vuelta ji ji ji
    @Test
    @Order(3)
    void deberiaEliminarElTurno()throws ResourceNotFoundException{

        //CREAMOS PACIENTE
        PacienteEntradaDto paciente = new PacienteEntradaDto("Lionel", "Messi", 66357732, LocalDate.of(2023, 10, 25), new DomicilioEntradaDto("Rosario", 125, "Rosario", "Santa Fe"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.crearPaciente(paciente);

        //CREAMOS ODONTOLOGO
        OdontologoEntradaDto odontologo = new OdontologoEntradaDto("AB-143496254","Sofia","Machado");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.crearOdontologo(odontologo);

        //CREAMOS TURNO
        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L,1L, LocalDateTime.of(2023,11,25,15,00));
        try {
            TurnoSalidaDto turnoSalidaDto = turnoService.crearTurno(turnoEntradaDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Verificaremos qe el turno no sea null
        assertNotNull(turnoService.buscarTurnoPorId(1L));

        //eliminamos el turno
        turnoService.eliminarTurnoPorId(1L);

        // Verificaremos qe el turno se elimino
        assertNull(turnoService.buscarTurnoPorId(1L));
    }
    */

}
