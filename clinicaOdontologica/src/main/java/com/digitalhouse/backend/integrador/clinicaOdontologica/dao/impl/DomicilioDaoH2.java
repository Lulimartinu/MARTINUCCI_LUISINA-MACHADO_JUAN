package com.digitalhouse.backend.integrador.clinicaOdontologica.dao.impl;


import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.H2Connection;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.IDao;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Domicilio;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final Logger LOGGER = LoggerFactory.getLogger(DomicilioDaoH2.class);
    private final String CTE_ERROR = "Ha ocurrido un error al intentar cerrar la bdd. {}";

    @Override
    public Domicilio registrar(Domicilio domicilio) {
        Connection connection = null;
        Domicilio domicilio1 = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();


            ResultSet rs = ps.getGeneratedKeys();
            domicilio1 = new Domicilio(domicilio.getCalle(), domicilio.getNumero(), domicilio.getLocalidad(), domicilio.getProvincia());
            while (rs.next()) {
                domicilio1.setId(rs.getLong("id"));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el domicilio: {}", domicilio1);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }

        }


        return domicilio1;
    }

    @Override
    public Domicilio buscarPorId(Long id) {
        Domicilio domicilio = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID = ?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }

            if (domicilio == null) LOGGER.error("No se ha encontrado el domicilio con id: {}", id);
            else LOGGER.info("Se ha encontrado el domicilio: {}", domicilio);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
            connection.commit();
            LOGGER.warn("Se ha eliminado el domicilio con id: {}", id);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }


    }

    @Override
    public List<Domicilio> listarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Domicilio domicilio = new Domicilio(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                domicilios.add(domicilio);
            }
            LOGGER.info("Listado de domicilios obtenido: " + domicilios);


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error(CTE_ERROR, ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilios;
    }

    @Override
    public Domicilio modificar(Domicilio domicilio) {
        return null;
    }


}

