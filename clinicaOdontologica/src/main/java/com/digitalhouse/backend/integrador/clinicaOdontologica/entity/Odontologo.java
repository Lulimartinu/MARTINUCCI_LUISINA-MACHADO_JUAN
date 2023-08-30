package com.digitalhouse.backend.integrador.clinicaOdontologica.entity;

public class Odontologo {
    private int id;
    private int numeroMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(int id, int numeroMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMatricula() {
        return this.numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String toString() {
        return "\nID: " + this.id + "\nNumero Matricula: " + this.numeroMatricula + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\n-----------------------";
    }
}