package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion;

import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteModificacionEntrada {
    @NotNull()
    private int id;
    @NotNull()
    private String nombrePaciente;
    @NotNull()
    private String apellidoPaciente;
    @NotNull()
    private int dni;
    @NotNull()
    private LocalDate fechaIngreso;
    @NotNull()
    private Domicilio domicilio;

    public PacienteModificacionEntrada() {
    }

    public PacienteModificacionEntrada(int id, String nombrePaciente, String apellidoPaciente, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
