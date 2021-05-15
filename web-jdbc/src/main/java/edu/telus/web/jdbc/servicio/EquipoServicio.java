package edu.telus.web.jdbc.servicio;

import edu.telus.web.jdbc.modelo.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class EquipoServicio {

    public void crear(Equipo equipo) throws SQLException {

        String queryString = "insert into equipo (nombre, direccion) values (?, ?)";

        Connection connection = ConexionDBSingleton.getConnection();

        try {
            
            int pk = -1;
            
            try (PreparedStatement stmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS)) {
                
                stmt.setString(1, equipo.getNombre());
                stmt.setString(2, equipo.getDireccion());
                
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        pk = rs.getInt(1);
                    }
                }
            }            
            equipo.setId(pk);
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }
    }

    public List<Equipo> buscarEquipos() throws SQLException {

        String queryString = "select * from equipo";

        List<Equipo> equipoList = new ArrayList<>();

        try (PreparedStatement stmt = ConexionDBSingleton.getConnection().prepareStatement(queryString)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setId(rs.getInt("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setDireccion(rs.getString("direccion"));

                    equipoList.add(equipo);
                }
            }
        }

        return equipoList;
    }
}
