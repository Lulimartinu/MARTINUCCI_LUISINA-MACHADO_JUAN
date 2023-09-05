package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService  implements IPacienteService {
    @Override
    public List<PacienteSalidaDto> detallarPacientes() {
        return null;
    }

    @Override
    public PacienteSalidaDto crearPaciente(PacienteEntradaDto paciente) {
        return null;
    }

    @Override
    public void eliminarPacientePorId(Long id) {

    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        return null;
    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteModificacionEntrada pacienteModificacionEntrada) {
        return null;
    }
}
