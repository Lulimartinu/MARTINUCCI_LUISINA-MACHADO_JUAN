package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;


import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.OdontologoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import com.digitalhouse.backend.integrador.clinicaOdontologica.repository.OdontoRepository;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IOdontologoService;
import org.h2.engine.Mode;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private final OdontoRepository odontoRepository;

    private final ModelMapper modelMapper;

    public OdontologoService(OdontoRepository odontoRepository, ModelMapper modelMapper) {
        this.odontoRepository = odontoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OdontologoSalidaDto> detallarOdontologos() {
        List<OdontologoSalidaDto> odontologos = odontoRepository.findAll().stream().map(this::entidadADtoSalida).toList();
        LOGGER.info("lista de todos los odontologos disponibles :{}",odontologos);
        return odontologos;
    }

    @Override
    public OdontologoSalidaDto crearOdontologo(OdontologoEntradaDto odontologo) {
        Odontologo odontoGuardado = odontoRepository.save(dtoEntradaAEntidad(odontologo));
        OdontologoSalidaDto odontologoSalidaDto = entidadADtoSalida(odontoGuardado);
        LOGGER.info("Se ha creado un nuevo Odontologo : {}", odontologoSalidaDto);
        return odontologoSalidaDto;
    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        Odontologo odontoBuscado = odontoRepository.findById(id).orElse(null);

        OdontologoSalidaDto odontologoSalidaDto = null;
        if(odontoBuscado != null){
            odontologoSalidaDto = entidadADtoSalida(odontoBuscado);
            LOGGER.info("Se ha encontrado el Odontologo: {}", odontologoSalidaDto);
        }
        else
            LOGGER.error("No se ha encontrado un Odontologo en la BDD con ese id");
        return odontologoSalidaDto;
    }


    @Override
    public void eliminarOdontologoPorId(Long id) {
        if(buscarOdontologoPorId(id) != null){
            odontoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el Odontologo con el id: {}", id);
        }
        else {
            LOGGER.error("No se ha encontrado un Odontologo en la BDD con ese id");
        }
    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntrada odontologoModificacionEntrada) {
        return null;
    }

    public Odontologo dtoEntradaAEntidad(OdontologoEntradaDto odontologoEntradaDto){
        return modelMapper.map(odontologoEntradaDto, Odontologo.class);
    }

    public OdontologoSalidaDto entidadADtoSalida(Odontologo odontologo){
        return modelMapper.map(odontologo,OdontologoSalidaDto.class);
    }

    public Odontologo dtoModificacionAEntidad(OdontologoModificacionEntrada odontologoModificacionEntrada){
        return modelMapper.map(odontologoModificacionEntrada, Odontologo.class);
    }


}
