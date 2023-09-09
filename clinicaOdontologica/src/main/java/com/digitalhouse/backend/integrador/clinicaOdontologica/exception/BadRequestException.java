package com.digitalhouse.backend.integrador.clinicaOdontologica.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
