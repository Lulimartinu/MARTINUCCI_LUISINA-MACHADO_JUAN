package com.digitalhouse.backend.integrador.clinicaOdontologica.dao.impl;

import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.H2Connection;
import com.digitalhouse.backend.integrador.clinicaOdontologica.dao.IDao;
import com.digitalhouse.backend.integrador.clinicaOdontologica.entity.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoH2.class);

    public OdontologoDaoH2() {
    }

    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologo1 = null;
        String insert = "INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(insert, 1);
            ps.setInt(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
            odontologo1 = new Odontologo(odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());
            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                odontologo.setId(rs.getLong(1));
            }

            connection.commit();
            if (odontologo1 == null) {
                this.LOGGER.error("No fue posible registrar el odontologo !");
            } else {
                this.LOGGER.info("Se ha registrado el odontologo :" + String.valueOf(odontologo1));
            }
        } catch (Exception var17) {
            Exception e = var17;
            this.LOGGER.error(var17.getMessage());
            var17.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema de conexion odontologica :)");
                    e.printStackTrace();
                } catch (SQLException var16) {
                    this.LOGGER.error(var16.getMessage());
                    var16.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception var15) {
                this.LOGGER.error("BUMMM... error al cerrar la ODONTO-BaseDeDatos " + var15.getMessage());
                var15.printStackTrace();
            }

        }

        return odontologo1;
    }

    @Override
    public Odontologo buscarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID = ?");
            ps.setLong(1, id);
            ps.execute();
            connection.commit();
            LOGGER.info("Se ha eliminado un odontologo");
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
                LOGGER.error("ERRORRRR, NO SE PUDO CERRAR LA BBDD", ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
        public List<Odontologo> listarTodos () {
            Connection connection = null;
            List<Odontologo> odontologos = new ArrayList();

            try {
                connection = H2Connection.getConnection();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Odontologo odontologo = new Odontologo(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                    odontologos.add(odontologo);
                }

                this.LOGGER.info("Listado de todos los odontologos : " + String.valueOf(odontologos));
            } catch (Exception var14) {
                this.LOGGER.error(var14.getMessage());
                var14.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception var13) {
                    this.LOGGER.error("ERORRRR, NO SE PUDO CERRAR LA BBDD" + var13.getMessage());
                    var13.printStackTrace();
                }

            }

            return odontologos;
        }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return null;
    }


}


