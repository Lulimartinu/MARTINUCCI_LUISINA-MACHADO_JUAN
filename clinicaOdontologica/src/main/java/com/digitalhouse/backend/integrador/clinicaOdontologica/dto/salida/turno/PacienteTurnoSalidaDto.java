package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.salida.turno;

public class PacienteTurnoSalidaDto {
    private Long id;
    private String nombrePaciente;
    private String apellidoPaciente;

    public PacienteTurnoSalidaDto() {
    }

    public PacienteTurnoSalidaDto(Long id, String nombrePaciente, String apellidoPaciente) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
