package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.paciente;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteEntradaDto {
    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "Debe completar con un nombre")
    @Size(min = 2, max = 50,message = "El nombre del Paciente debe tener un mini de 2 y max de 50 caracteres")
    private String nombrePaciente;
    @NotNull(message = "El apellido del paciente no puede ser nulo")
    @NotBlank(message = "Debe completar con un apellido")
    private String apellidoPaciente;
    @NotNull(message = "El dni del paciente no puede ser nulo")
    @Digits(integer = 8,fraction = 0,message = "El dni debe tener como maximo 8 digitos")
    private int dni;
    @NotNull(message = "La fecha de ingreso no puede ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    private LocalDate fechaIngreso;
    @NotNull(message = "El Domicilio  no puede ser nula")
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