package com.digitalhouse.backend.integrador.clinicaOdontologica.service;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.OdontologoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {

    List<OdontologoSalidaDto> detallarOdontologos();
    OdontologoSalidaDto crearOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologoPorId(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntrada odontologoModificacionEntrada) throws ResourceNotFoundException;





}
