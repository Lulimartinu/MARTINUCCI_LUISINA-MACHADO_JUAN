package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoModificacionEntrada {
    @NotNull()
    private int id;
    @NotNull()
    private String numeroMatricula;
    @NotNull()
    private String nombreOdontologo;
    @NotNull()
    private String apellidoOdontologo;

    public OdontologoModificacionEntrada() {
    }

    public OdontologoModificacionEntrada(int id, String numeroMatricula, String nombreOdontologo, String apellidoOdontologo) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombreOdontologo() {
        return nombreOdontologo;
    }

    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }

    public String getApellidoOdontologo() {
        return apellidoOdontologo;
    }

    public void setApellidoOdontologo(String apellidoOdontologo) {
        this.apellidoOdontologo = apellidoOdontologo;
    }
}
