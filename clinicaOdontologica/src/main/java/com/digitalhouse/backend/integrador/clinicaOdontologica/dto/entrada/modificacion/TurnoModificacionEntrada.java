package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoModificacionEntrada {
    @NotNull()
    private Long id;
    @NotNull()
    private Odontologo odontologo;
    @NotNull()
    private Paciente paciente;
    @NotNull()
    private LocalDateTime fechaYHora;

    public TurnoModificacionEntrada() {
    }

    public TurnoModificacionEntrada(Long id, Odontologo odontologo, Paciente paciente, LocalDateTime fechaYHora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
