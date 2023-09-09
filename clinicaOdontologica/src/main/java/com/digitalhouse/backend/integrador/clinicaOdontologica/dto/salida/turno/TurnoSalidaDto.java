package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TurnoSalidaDto {
    private Long id;
    private PacienteTurnoSalidaDto pacienteTurnoSalidaDto;
    private OdontoTurnoSalidaDto odontoTurnoSalidaDto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaYHora;

    public TurnoSalidaDto(Long id, PacienteTurnoSalidaDto pacienteTurnoSalidaDto, OdontoTurnoSalidaDto odontoTurnoSalidaDto, LocalDateTime fechaYHora) {
        this.id = id;
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
        this.odontoTurnoSalidaDto = odontoTurnoSalidaDto;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteTurnoSalidaDto getPacienteTurnoSalidaDto() {
        return pacienteTurnoSalidaDto;
    }

    public void setPacienteTurnoSalidaDto(PacienteTurnoSalidaDto pacienteTurnoSalidaDto) {
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
    }

    public OdontoTurnoSalidaDto getOdontoTurnoSalidaDto() {
        return odontoTurnoSalidaDto;
    }

    public void setOdontoTurnoSalidaDto(OdontoTurnoSalidaDto odontoTurnoSalidaDto) {
        this.odontoTurnoSalidaDto = odontoTurnoSalidaDto;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    @Override
    public String toString() {
        return "TurnoSalidaDto{" +
                "id=" + id +
                ", pacienteTurnoSalidaDto=" + pacienteTurnoSalidaDto +
                ", odontoTurnoSalidaDto=" + odontoTurnoSalidaDto +
                ", fechaYHora=" + fechaYHora +
                '}';
    }
}
