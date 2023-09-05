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
        List<OdontologoSalidaDto> odontologos = odontoRepository.findAll().stream().map(o -> modelMapper.map(o, OdontologoSalidaDto.class)).toList();
        LOGGER.info("lista de todos los odontologos disponibles :{}",odontologos);
        return odontologos;
    }

    @Override
    public OdontologoSalidaDto crearOdontologo(OdontologoEntradaDto odontologo) {
        Odontologo odontoGuardado = odontoRepository.save(modelMapper.map(odontologo, Odontologo.class));
        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontoGuardado, OdontologoSalidaDto.class);
        LOGGER.info("Se ha creado un nuevo Odontologo : {}", odontologoSalidaDto);
        return odontologoSalidaDto;
    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {


        return null;
    }

    @Override
    public void eliminarOdontologoPorId(Long id) {

    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntrada odontologoModificacionEntrada) {
        return null;
    }
}
