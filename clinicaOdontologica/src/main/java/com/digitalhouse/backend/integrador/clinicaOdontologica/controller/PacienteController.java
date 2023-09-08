package com.digitalhouse.backend.integrador.clinicaOdontologica.controller;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/crear")
    public ResponseEntity<PacienteSalidaDto> crearPaciente(@Valid @RequestBody PacienteEntradaDto paciente) {
        return new ResponseEntity<>(pacienteService.crearPaciente(paciente), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteSalidaDto> actualizarPaciente(@Valid @RequestBody PacienteModificacionEntrada paciente) {
        return new ResponseEntity<>(pacienteService.actualizarPaciente(paciente), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id ) {
        pacienteService.eliminarPacientePorId(id);
        return new ResponseEntity<>("Se ha eliminado el paciente con id : {}" + id, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> buscarPacientePorId(@PathVariable Long id){
        return new ResponseEntity<>(pacienteService.buscarPacientePorId(id), HttpStatus.OK);
    }

    @GetMapping("/detallar")
    public ResponseEntity<List<PacienteSalidaDto>> detallarPacientes(){
        return new ResponseEntity<>(pacienteService.detallarPacientes(),HttpStatus.OK);
    }

}
