package com.digitalhouse.backend.integrador.clinicaOdontologica.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
