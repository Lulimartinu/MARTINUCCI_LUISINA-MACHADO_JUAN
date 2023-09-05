package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.TurnoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    @Override
    public List<TurnoSalidaDto> detallarTurnos() {
        return null;
    }

    @Override
    public TurnoSalidaDto crearTurno(TurnoEntradaDto turno) {
        return null;
    }

    @Override
    public void eliminarTurnoPorId(Long id) {

    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        return null;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntrada turnoModificacionEntrada) {
        return null;
    }
}
