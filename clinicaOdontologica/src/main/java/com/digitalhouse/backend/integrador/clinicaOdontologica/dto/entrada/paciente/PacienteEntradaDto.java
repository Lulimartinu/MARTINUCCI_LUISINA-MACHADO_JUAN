package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PacienteEntradaDto {
    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "Debe completar con un nombre")
    private String nombrePaciente;
    private String apellidoPaciente;
    private int dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombrePaciente, String apellidoPaciente, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}