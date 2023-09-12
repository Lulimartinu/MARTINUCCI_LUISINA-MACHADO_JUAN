package com.digitalhouse.backend.integrador.clinicaOdontologica.controller;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.OdontologoModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion.PacienteModificacionEntrada;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.digitalhouse.backend.integrador.clinicaOdontologica.exception.ResourceNotFoundException;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IOdontologoService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.IPacienteService;
import com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl.OdontologoService;
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
@RequestMapping("/odontologos")
@CrossOrigin
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @Operation(summary = "CREACIÓN DE UN ODONTÓLOGO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Odontólogo creado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PostMapping("/crear")
    public ResponseEntity<OdontologoSalidaDto> crearOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.crearOdontologo(odontologo), HttpStatus.CREATED);
    }

    @Operation(summary = "ACTUALIZACIÓN DE UN ODONTÓLOGO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El odontólogo se actualizó correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontólogo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoModificacionEntrada odontologo ) throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
    }

    @Operation(summary = "ELIMINACIÓN DE ODONTÓLOGO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Odontólogo eliminado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontólogo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id ) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologoPorId(id);
        return new ResponseEntity<>("Se ha eliminado el Odontologo con id : {}" + id, HttpStatus.OK);
    }

    @Operation(summary = "BÚSQUEDA DE ODONTÓLOGO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontólogo obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta, id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontólogo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> buscarOdontologoPorId(@PathVariable Long id){
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }
    @Operation(summary = "LISTADO DE ODONTÓLOGOS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de odontólogos obtenido",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "La petición no es correcta (BAD REQUEST)",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "ERROR DEL SERVIDOR",
                    content = @Content)
    })
    @GetMapping("/detallar")
    public ResponseEntity<List<OdontologoSalidaDto>> detallarOdontologos(){
        return new ResponseEntity<>(odontologoService.detallarOdontologos(),HttpStatus.OK);
    }

}