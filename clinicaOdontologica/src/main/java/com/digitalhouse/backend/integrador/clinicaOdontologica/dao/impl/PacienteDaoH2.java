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

/*
public class PacienteDaoH2 implements IDao<Paciente> {
   /* private final Logger LOGGER = LoggerFactory.getLogger(PacienteDaoH2.class);
    private final String CTE_ERROR = "Ha ocurrido un error al intentar cerrar la bdd. {}";

    @Override
    public Paciente registrar(Paciente paciente) {
        Connection connection = null;
        Paciente paciente1 = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            Domicilio domicilio = domicilioDaoH2.registrar(paciente.getDomicilio());

            PreparedStatement ps = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombrePaciente());
            ps.setString(2, paciente.getApellidoPaciente());
            ps.setInt(3, paciente.getDni());
            ps.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            ps.setLong(5, domicilio.getId());
            ps.execute();

            paciente1 = new Paciente(paciente.getNombrePaciente(), paciente.getApellidoPaciente(), paciente.getDni(), paciente.getFechaIngreso(), domicilio);

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                paciente1.setId(rs.getLong(1));
            }

            connection.commit();
            if (paciente1 == null) LOGGER.error("No fue posible registrar al paciente");
            else LOGGER.info("Se ha registrado el paciente: {}", paciente1);


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
            } catch (Exception e) {
                LOGGER.error(CTE_ERROR, e.getMessage());
                e.printStackTrace();
            }
        }

        return paciente1;
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Connection connection = null;
        Paciente paciente = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES WHERE ID = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente = crearObjetoPaciente(rs);
            }

            if (paciente == null) LOGGER.error("No se ha encontrado el paciente con id: {}", id);
            else LOGGER.info("Se ha encontrado el paciente: {}", paciente);


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


        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("DELETE FROM PACIENTES WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
            connection.commit();
            LOGGER.info("Se ha eliminado el paciente con id: {}", id);

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
    public List<Paciente> listarTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PACIENTES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = crearObjetoPaciente(rs);
                pacientes.add(paciente);
            }

            LOGGER.info("Listado de todos los pacientes: {}", pacientes);

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
        return pacientes;
    }

    @Override
    public Paciente modificar(Paciente pacienteModificado) {

        Connection connection = null;
        try {
            connection = H2Connection.getConnection();

            PreparedStatement ps = connection.prepareStatement("UPDATE PACIENTES SET NOMBRE = ?, APELLIDO = ?, DNI = ?, FECHA = ?, DOMICILIO_ID = ? WHERE ID = ?");
            ps.setString(1, pacienteModificado.getNombrePaciente());
            ps.setString(2, pacienteModificado.getApellidoPaciente());
            ps.setInt(3, pacienteModificado.getDni());
            ps.setDate(4, Date.valueOf(pacienteModificado.getFechaIngreso()));
            ps.setLong(5, pacienteModificado.getDomicilio().getId());
            ps.setLong(6, pacienteModificado.getId());
            ps.execute();

            LOGGER.warn("El paciente con id " + pacienteModificado.getId() + "ha sido modificado: " + pacienteModificado);

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return pacienteModificado;
    }

    private Paciente crearObjetoPaciente(ResultSet resultSet) throws SQLException {
        Long idPaciente = resultSet.getLong("id");
        String nombrePaciente = resultSet.getString("nombre");
        String apellidoPaciente = resultSet.getString("apellido");
        int dniPaciente = resultSet.getInt("dni");
        LocalDate fechaIngreso = resultSet.getDate("fecha").toLocalDate();

        Domicilio domicilioPaciente = new DomicilioDaoH2().buscarPorId(resultSet.getLong("domicilio_id"));

        return new Paciente(idPaciente, nombrePaciente, apellidoPaciente, dniPaciente,fechaIngreso, domicilioPaciente);}

 } */
