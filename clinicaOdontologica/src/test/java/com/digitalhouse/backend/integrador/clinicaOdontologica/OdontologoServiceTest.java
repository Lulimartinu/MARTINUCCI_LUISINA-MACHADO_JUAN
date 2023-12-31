package com.digitalhouse.backend.integrador.clinicaOdontologica;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.OdontologoService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaCrearUnOdontologoConNombreLuciana(){
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AA-123456789","Luciana","Murga");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.crearOdontologo(odontologoEntradaDto);

        assertEquals("Luciana",odontologoSalidaDto.getNombreOdontologo());

    }
    @Test
    @Order(2)
    void alQuererEliminarElOdontologConId2_DeberiaArrojarResourceNotFound(){
        try {
            odontologoService.eliminarOdontologoPorId(2L);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologoPorId(2L));

    }
    @Test
    @Order(3)
    void deberiaRetornarseUnaListaConTresOdontologos(){
        OdontologoEntradaDto odonto1 = new OdontologoEntradaDto("AD-154236781",
                "luisina",
                "martinucci");
        OdontologoEntradaDto odonto2 = new OdontologoEntradaDto("AD-154236782",
                "Juan",
                "Machado");
        odontologoService.crearOdontologo(odonto1);
        odontologoService.crearOdontologo(odonto2);

        assertEquals(odontologoService.detallarOdontologos().size(),3);
    }
}
