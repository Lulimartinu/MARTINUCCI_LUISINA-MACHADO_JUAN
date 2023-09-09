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
    private int numeroMatricula;

    @NotBlank(message = "Odontologo debe tener nombre")
    @NotNull(message = "Nombre de odontologo no puede ser nulo")
    @Size(max = 50,message = "El nombre odontologo debe tener maximo 50 caracteres")
    private String nombre;

    @NotBlank(message = "Odontologo debe tener Apellido")
    @NotNull(message = "Apellido de odontologo no puede ser nulo")
    @Size(max = 50,message = "El apellido odontologo debe tener maximo 50 caracteres")
    private String apellido;

    public OdontologoEntradaDto(int numeroMatricula, String nombre, String apellido) {

        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public OdontologoEntradaDto() {
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
