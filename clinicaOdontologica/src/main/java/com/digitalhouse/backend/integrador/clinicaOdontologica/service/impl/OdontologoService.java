package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;


import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.IDao;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.OdontologoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import com.digitalhouse.backend.integrador.clinicaOdontologica.repository.OdontoRepository;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IOdontologoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private final OdontoRepository odontoRepository;

    @Override
    public List<OdontologoSalidaDto> detallarOdontologos() {

        return null;
    }

    @Override
    public OdontologoSalidaDto crearOdontologo(OdontologoEntradaDto odontologo) {
        return null;
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
