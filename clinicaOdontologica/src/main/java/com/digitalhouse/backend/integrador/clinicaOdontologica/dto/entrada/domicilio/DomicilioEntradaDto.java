package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.domicilio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DomicilioEntradaDto {
    @NotNull(message = "La calle no puede ser nula")
    @NotBlank(message = "Debe completar con una calle")
    private String calle;
    @NotNull(message = "El nro no puede ser nula")
    @NotBlank(message = "Debe completar con un numero")
    @Pattern(regexp = "\\d{1,8}", message = "El número debe tener como máximo 8 dígitos")
    private int numero;
    @NotNull(message = "La localidad no puede ser nula")
    @NotBlank(message = "Debe completar con una localidad")
    private String localidad;
    @NotNull(message = "La Provincia no puede ser nula")
    @NotBlank(message = "Debe completar con una Provincia")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}
