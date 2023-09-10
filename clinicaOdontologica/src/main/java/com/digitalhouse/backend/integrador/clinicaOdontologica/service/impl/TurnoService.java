package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.TurnoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.OdontoTurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.PacienteTurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Turno;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.repository.TurnoRepository;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);
    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final OdontologoService odontologoService;
    private final PacienteService pacienteService;



    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }



    @Override
    public List<TurnoSalidaDto> detallarTurnos() throws ResourceNotFoundException{
        List<TurnoSalidaDto> turnos = turnoRepository.findAll().stream().map(this::entidadADto).toList();
        LOGGER.info("lista de todos los turnos disponibles :{} ", turnos);
        return turnos;
    }

    @Override
    public TurnoSalidaDto crearTurno(TurnoEntradaDto turno) throws BadRequestException {
        TurnoSalidaDto turnoSalidaDto;
        PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turno.getPacienteId());
        OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turno.getOdontologoId());

        if (paciente == null || odontologo == null) {
            if (paciente == null && odontologo == null) {
                LOGGER.error("El Paciente y el Odontologo no se encuentran en nuestra BDD");
                throw new BadRequestException("El Paciente y el Odontologo no se encuentran en nuestra BDD");

            } else if (paciente == null) {
                LOGGER.error("No se encuentra el Paciente en nuestra BDD");
                throw new BadRequestException("No se encuentra el Paciente en nuestra BDD");
            } else {
                LOGGER.error("No se encuentra el Odontologo en nuestra BDD");
                throw new BadRequestException("No se encuentra el Odontologo en nuestra BDD");
            }
        } else {
            Turno turnoCreado = turnoRepository.save(modelMapper.map(turno, Turno.class));
            turnoSalidaDto = entidadADto(turnoCreado);
            LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
        }

        return turnoSalidaDto;


    }

    @Override
    public void eliminarTurnoPorId(Long id) throws ResourceNotFoundException{
        if (buscarTurnoPorId(id) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con el id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado un Turno en la BDD con ese id");
            throw new ResourceNotFoundException("No se ha encontrado un Turno en la BDD con ese id");
        }

    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id){
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoSalidaDto = null;

        if (turnoBuscado != null) {
            turnoSalidaDto = entidadADto(turnoBuscado);
            LOGGER.info("Se ha encontrado el Turno: {}", turnoSalidaDto);
        } else
        LOGGER.error("No se ha encontrado un Turno en la BDD con ese id " + id );

        return turnoSalidaDto;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntrada turnoModificacionEntrada) throws ResourceNotFoundException {
        Turno turnoAActualizar= turnoRepository.findById(turnoModificacionEntrada.getId()).orElse(null);
        TurnoSalidaDto turnoSalidaDto = null;
        if(turnoAActualizar != null){
            turnoAActualizar.setPaciente(modelMapper.map(pacienteService.buscarPacientePorId(turnoModificacionEntrada.getPaciente().getId()), Paciente.class));
            turnoAActualizar.setOdontologo(modelMapper.map(odontologoService.buscarOdontologoPorId(turnoModificacionEntrada.getOdontologo().getId()), Odontologo.class));
            turnoAActualizar.setFechaYHora(turnoModificacionEntrada.getFechaYHora());
            turnoRepository.save(turnoAActualizar);

            turnoSalidaDto = entidadADto(turnoAActualizar);
            LOGGER.warn("Se ha actualizado el turno: {}", turnoSalidaDto);
        }
        else {
            LOGGER.error("No se ha podido actualizar el turno");
            throw new ResourceNotFoundException("No se ha podido actualizar el turno");
        }

        return turnoSalidaDto;
    }

    /*
    private void configureMapping() {

        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class)
                .addMapping(TurnoEntradaDto::getPacienteId, Turno::setPaciente)
                .addMapping(TurnoEntradaDto::getOdontologoId, Turno::setOdontologo);

        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class)
                .addMapping(Turno::getPaciente, TurnoSalidaDto::setPacienteTurnoSalidaDto)
                .addMapping(Turno::getOdontologo, TurnoSalidaDto::setOdontoTurnoSalidaDto);
    }*/


    private PacienteTurnoSalidaDto pacSalDtoASalTurnoDto(Long id)  {
        return modelMapper.map(pacienteService.buscarPacientePorId(id), PacienteTurnoSalidaDto.class);
    }

    private OdontoTurnoSalidaDto odontoSalDtoASalTurnoDto(Long id) {
        return modelMapper.map(odontologoService.buscarOdontologoPorId(id), OdontoTurnoSalidaDto.class);
    }

    private TurnoSalidaDto entidadADto(Turno turno)  {
        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
        turnoSalidaDto.setPacienteTurnoSalidaDto(pacSalDtoASalTurnoDto(turno.getPaciente().getId()));
        turnoSalidaDto.setOdontoTurnoSalidaDto(odontoSalDtoASalTurnoDto(turno.getOdontologo().getId()));
        return turnoSalidaDto;
                                }

}
