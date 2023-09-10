package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
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
        configureMapping();
    }

        @Override
        public List<PacienteSalidaDto> detallarPacientes() {
            List<PacienteSalidaDto> pacientes = pacienteRepository.findAll().stream().map(this::entidadADtoSalida).toList();
            LOGGER.info("lista de todos los pacientes disponibles :{}", pacientes);
            return pacientes;
        }

        @Override
        public PacienteSalidaDto crearPaciente(PacienteEntradaDto paciente) throws BadRequestException{
            Paciente pacienteGuardado = pacienteRepository.save(dtoEntradaAEntidad(paciente));
            PacienteSalidaDto pacienteSalidaDto = entidadADtoSalida(pacienteGuardado);
            LOGGER.info("Se ha creado un nuevo Paciente : {}", pacienteSalidaDto);
            return pacienteSalidaDto;
        }

        @Override
        public void eliminarPacientePorId(Long id) throws ResourceNotFoundException {
            if (buscarPacientePorId(id) != null) {
                pacienteRepository.deleteById(id);
                LOGGER.warn("Se ha eliminado el Paciente con el id: {}", id);
            } else {
                LOGGER.error("No se ha encontrado un Paciente en la BDD con el id: " + id);
                throw new ResourceNotFoundException("No se ha encontrado un Paciente en la BDD con el id: "  + id);
            }

        }

        @Override
        public PacienteSalidaDto buscarPacientePorId(Long id) throws ResourceNotFoundException{
            Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);
            PacienteSalidaDto pacienteSalidaDto = null;

            if (pacienteBuscado != null) {
                pacienteSalidaDto = entidadADtoSalida(pacienteBuscado);
                LOGGER.info("Se ha encontrado el Paciente: {}", pacienteSalidaDto);
            } else
            {LOGGER.error("No se ha encontrado un Paciente en la BDD con el id" + id);
            throw new ResourceNotFoundException("No se ha encontrado un Paciente en la BDD con el id: " + id);
            }

            return pacienteSalidaDto;
        }

        @Override
        public PacienteSalidaDto actualizarPaciente(PacienteModificacionEntrada pacienteModificacionEntrada) throws ResourceNotFoundException {
            Paciente pacienteAActualizar = dtoModificacionAEntidad(pacienteModificacionEntrada);
            Paciente pacienteActualizado = pacienteRepository.findById(pacienteAActualizar.getId()).orElse(null);
            PacienteSalidaDto pacienteSalidaDto = null;


            if (pacienteAActualizar != null) {
                pacienteRepository.save(pacienteActualizado);
                pacienteActualizado = pacienteAActualizar;
                pacienteSalidaDto = entidadADtoSalida(pacienteActualizado);
                LOGGER.warn("Se ha actualizado el Paciente: {}", pacienteActualizado);
            } else {LOGGER.error("No se ha encontrado un Paciente en la BDD con ese id");
            throw new ResourceNotFoundException("No se ha encontrado un Paciente en la BDD con ese id");}
            return pacienteSalidaDto;
        }


        private void configureMapping() {
            modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                    .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilio, Paciente::setDomicilio));
            modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                    .addMappings(mapper -> mapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilio));
            modelMapper.typeMap(PacienteModificacionEntrada.class, Paciente.class)
                    .addMappings(mapper -> mapper.map(PacienteModificacionEntrada::getDomicilio, Paciente::setDomicilio));

        }

        private Paciente dtoEntradaAEntidad(PacienteEntradaDto pacienteEntradaDto) {
            return modelMapper.map(pacienteEntradaDto, Paciente.class);
        }

        private PacienteSalidaDto entidadADtoSalida(Paciente paciente) {
            return modelMapper.map(paciente, PacienteSalidaDto.class);
        }

        public Paciente dtoModificacionAEntidad(PacienteModificacionEntrada pacienteEntradaDto) {
            return modelMapper.map(pacienteEntradaDto, Paciente.class);
        }

    }




