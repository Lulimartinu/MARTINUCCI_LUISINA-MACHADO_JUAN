package com.digitalhouse.backend.integrador.clinicaOdontologica.controller;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {
    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @Operation(summary = "CREACIÓN DE UN PACIENTE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente creado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<PacienteSalidaDto> crearPaciente(@RequestBody @Valid PacienteEntradaDto paciente) throws BadRequestException {
        return new ResponseEntity<>(pacienteService.crearPaciente(paciente), HttpStatus.CREATED);
    }

    @Operation(summary = "ACTUALIZACIÓN DE UN PACIENTE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El paciente se actualizó correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PutMapping("/actualizar")
    public ResponseEntity<PacienteSalidaDto> actualizarPaciente(@Valid @RequestBody PacienteModificacionEntrada paciente) throws ResourceNotFoundException {
        return new ResponseEntity<>(pacienteService.actualizarPaciente(paciente), HttpStatus.OK);
    }
    @Operation(summary = "ELIMINACIÓN DE PACIENTE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Paciente eliminado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id ) throws ResourceNotFoundException {
        pacienteService.eliminarPacientePorId(id);
        return new ResponseEntity<>("Se ha eliminado el paciente con id : {}" + id, HttpStatus.OK);
    }
    @Operation(summary = "BÚSQUEDA DE PACIENTE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Paciente no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> buscarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(pacienteService.buscarPacientePorId(id), HttpStatus.OK);
    }
    @Operation(summary = "LISTADO DE PACIENTES")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de pacientes obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("/detallar")
    public ResponseEntity<List<PacienteSalidaDto>> detallarPacientes(){
        return new ResponseEntity<>(pacienteService.detallarPacientes(),HttpStatus.OK);
    }

}
