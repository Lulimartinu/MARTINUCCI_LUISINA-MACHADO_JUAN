package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.odontologo;

public class OdontologoSalidaDto {
    private Long id;
    private String numeroMatricula;
    private String nombreOdontologo;
    private String apellidoOdontologo;

    public OdontologoSalidaDto() {
    }

    public OdontologoSalidaDto(Long id, String numeroMatricula, String nombreOdontologo, String apellidoOdontologo) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }

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
        return "OdontologoSalidaDto{" +
                "id=" + id +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", nombreOdontologo='" + nombreOdontologo + '\'' +
                ", apellidoOdontologo='" + apellidoOdontologo + '\'' +
                '}';
    }
}
