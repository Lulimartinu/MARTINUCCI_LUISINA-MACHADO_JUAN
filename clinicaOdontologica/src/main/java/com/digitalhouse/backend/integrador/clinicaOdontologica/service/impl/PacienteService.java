package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.repository.PacienteRepository;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService  implements IPacienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);


    private final PacienteRepository pacienteRepository;

    private final ModelMapper modelMapper;


    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

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
