package com.digitalhouse.backend.integrador.clinicaOdontologica.entity;

import javax.persistence.*;

@Entity
@Table(name = "ODONTOLOGOS",uniqueConstraints = {@UniqueConstraint(columnNames = {"numeroMatricula"})})

public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroMatricula;
    @Column(length = 50)
    private String nombreOdontologo;
    @Column(length = 50)
    private String apellidoOdontologo;


    public Odontologo() {
    }

    public Odontologo(String numeroMatricula, String nombreOdontologo, String apellidoOdontologo) {
        this.numeroMatricula = numeroMatricula;
        this.nombreOdontologo = nombreOdontologo;
        this.apellidoOdontologo = apellidoOdontologo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return this.numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return this.nombreOdontologo;
    }

    public void setNombre(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }

    public String getApellido() {
        return this.apellidoOdontologo;
    }

    public void setApellido(String apellidoOdontologo) {
        this.apellidoOdontologo = apellidoOdontologo;
    }

}