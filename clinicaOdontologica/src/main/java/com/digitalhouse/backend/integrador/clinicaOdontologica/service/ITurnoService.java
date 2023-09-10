package com.digitalhouse.backend.integrador.clinicaOdontologica.service;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.TurnoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Turno;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    List<TurnoSalidaDto> detallarTurnos() throws ResourceNotFoundException;

    TurnoSalidaDto crearTurno(TurnoEntradaDto turno) throws BadRequestException;
    void eliminarTurnoPorId(Long id) throws ResourceNotFoundException;
    TurnoSalidaDto buscarTurnoPorId(Long id) ;
    TurnoSalidaDto actualizarTurno(TurnoModificacionEntrada turnoModificacionEntrada) throws ResourceNotFoundException;


}
