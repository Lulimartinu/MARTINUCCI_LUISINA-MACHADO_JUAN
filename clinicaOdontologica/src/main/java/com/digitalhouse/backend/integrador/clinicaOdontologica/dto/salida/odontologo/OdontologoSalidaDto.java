package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo;

public class OdontologoSalidaDto {
    private Long id;
    private String numeroMatricula;
    private String nombreOdontologo;
    private String apellidoOdontologo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombreOdontologo;
    }

    public void setNombre(String nombre) {
        this.nombreOdontologo = nombreOdontologo;
    }

    public String getApellido() {
        return apellidoOdontologo;
    }

    public void setApellido(String apellido) {
        this.apellidoOdontologo = apellidoOdontologo;
    }

    public OdontologoSalidaDto() {
    }

    public OdontologoSalidaDto(Long id, String numeroMatricula, String nombreOdontologo, String apellidoOdontologo) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }
}
