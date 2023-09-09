package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.turno;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoEntradaDto {
    @NotNull(message = "El Odontologo no puede ser nulo")
    private Long odontologoId;
    @NotNull(message = "El Paciente no puede ser nulo")
    private Long pacienteId;
    @NotNull(message = "Debe ingresar una fecha y hora deseada")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    private LocalDateTime fechaYHora;

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
