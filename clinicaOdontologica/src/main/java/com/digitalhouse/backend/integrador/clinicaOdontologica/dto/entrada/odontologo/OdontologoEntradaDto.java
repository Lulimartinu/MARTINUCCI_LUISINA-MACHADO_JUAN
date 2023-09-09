package com.digitalhouse.backend.integrador.clinicaOdontologica.dto.entrada.odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoEntradaDto {
    @NotNull(message = "Numero Matricula no puede ser nulo")
    @Pattern(regexp = "^[A-Z]{2}-\\d{1,3}\\d*$")
    @Size(min = 10, message = "La matricula debe tener 10 caracteres mínimo")
    @Size(max = 12,message = "La matricula debe tener 12 caracteres Maximo")
    private String numeroMatricula;

    @NotBlank(message = "Odontologo debe tener nombre")
    @NotNull(message = "Nombre de odontologo no puede ser nulo")
    @Size(max = 50,message = "El nombre odontologo debe tener maximo 50 caracteres")
    private String nombreOdontologo;

    @NotBlank(message = "Odontologo debe tener Apellido")
    @NotNull(message = "Apellido de odontologo no puede ser nulo")
    @Size(max = 50,message = "El apellido odontologo debe tener maximo 50 caracteres")
    private String apellidoOdontologo;

    public OdontologoEntradaDto(String numeroMatricula, String nombreOdontologo, String apellidoOdontologo) {

        this.numeroMatricula = numeroMatricula;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }

    public OdontologoEntradaDto() {
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
