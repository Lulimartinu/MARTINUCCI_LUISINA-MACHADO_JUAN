package com.digitalhouse.backend.integrador.clinicaOdontologica.service;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> detallarPacientes();

    PacienteSalidaDto crearPaciente(PacienteEntradaDto paciente);
    void eliminarPacientePorId(Long id) ; //throws ResourceNotFoundException;
    PacienteSalidaDto buscarPacientePorId(Long id);
    PacienteSalidaDto actualizarPaciente(PacienteModificacionEntrada pacienteModificacionEntrada);

}
