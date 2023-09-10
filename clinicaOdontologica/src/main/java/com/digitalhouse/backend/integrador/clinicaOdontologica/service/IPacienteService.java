package com.digitalhouse.backend.integrador.clinicaOdontologica.service;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> detallarPacientes();

    PacienteSalidaDto crearPaciente(PacienteEntradaDto paciente) throws BadRequestException;
    void eliminarPacientePorId(Long id) throws ResourceNotFoundException;
    PacienteSalidaDto buscarPacientePorId(Long id) throws ResourceNotFoundException;
    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntrada pacienteModificacionEntrada) throws ResourceNotFoundException;

}
