package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontoTurnoSalidaDto {
    private Long id;
    private String nombreOdontologo;
    private String apellidoOdontologo;

    public OdontoTurnoSalidaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "OdontoTurnoSalidaDto{" +
                "id=" + id +
                ", nombreOdontologo='" + nombreOdontologo + '\'' +
                ", apellidoOdontologo='" + apellidoOdontologo + '\'' +
                '}';
    }
}

