package com.digitalhouse.backend.integrador.clinicaOdontologica.service.impl;


import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.IDao;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return (Odontologo)this.odontologoIDao.registrar(odontologo);
    }

    public List<Odontologo> listarOdontologos() {
        return this.odontologoIDao.listarTodos();
    }
}
