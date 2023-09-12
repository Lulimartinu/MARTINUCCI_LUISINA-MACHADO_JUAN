package com.digitalhouse.backend.integrador.clinicaOdontologica.controller;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.TurnoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.BadRequestException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.ITurnoService;
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
@RequestMapping("/turnos")
@CrossOrigin
public class TurnoController {
    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @Operation(summary = "CREACIÓN DE UN TURNO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Turno creado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<TurnoSalidaDto> crearTurno(@Valid @RequestBody TurnoEntradaDto turno) throws BadRequestException, ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.crearTurno(turno), HttpStatus.CREATED);
    }

    @Operation(summary = "ACTUALIZACIÓN DE UN TURNO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El Turno se actualizó correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PutMapping("/actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@Valid @RequestBody TurnoModificacionEntrada turno) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.actualizarTurno(turno), HttpStatus.OK);
    }

    @Operation(summary = "ELIMINACIÓN DE TURNO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Turno eliminado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id ) throws ResourceNotFoundException {
        turnoService.eliminarTurnoPorId(id);
        return new ResponseEntity<>("Se ha eliminado el Turno con id : {}" + id, HttpStatus.OK);
    }

    @Operation(summary = "BÚSQUEDA DE TURNO ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Turno obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> buscarTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), HttpStatus.OK);
    }

    @Operation(summary = "LISTADO DE TURNOS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de Turnos obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("/detallar")
    public ResponseEntity<List<TurnoSalidaDto>> detallarTurnos() throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.detallarTurnos(),HttpStatus.OK);
    }

}