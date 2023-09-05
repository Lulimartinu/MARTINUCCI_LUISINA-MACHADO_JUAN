package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno;

public class OdontoTurnoSalidaDto {
    private Long id;
    private String nombreOdonto;
    private String apellidoOdonto;

    public OdontoTurnoSalidaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreOdonto() {
        return nombreOdonto;
    }

    public void setNombreOdonto(String nombreOdonto) {
        this.nombreOdonto = nombreOdonto;
    }

    public String getApellidoOdonto() {
        return apellidoOdonto;
    }

    public void setApellidoOdonto(String apellidoOdonto) {
        this.apellidoOdonto = apellidoOdonto;
    }
}

