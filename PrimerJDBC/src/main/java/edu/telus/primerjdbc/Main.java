package edu.telus.primerjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Mario Batres
 */
public class Main {

    public void mostrarJugadores(Connection connection) throws SQLException {
        String queryString = "select * from jugador";

        try (PreparedStatement stmt = connection.prepareStatement(queryString)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    System.out.print(rs.getInt("id") + "\t");
                    System.out.print(rs.getString("nombre") + "\t");
                    System.out.print(rs.getString("apellido") + "\t");
                    System.out.print(rs.getInt("edad") + "\t");
                    System.out.print(rs.getInt("pais_nacimiento") + "\t");
                    System.out.println(rs.getInt("liga_actual"));

                }
            }
        }
    }

    public void mostrarDatos(Connection connection, String queryString) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(queryString)) {

            try (ResultSet rs = stmt.executeQuery()) {

                int columnas = rs.getMetaData().getColumnCount();

                for (int i = 1; i <= columnas; i++) {
                    System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
                }

                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= columnas; i++) {
                        System.out.print(rs.getObject(i) + "\t");
                    }
                    System.out.println();
                }
            }
        }
    }

    public void insertarJugador(Connection connection) throws SQLException {
        try {

            String queryString = "insert into jugador (nombre, apellido, edad, pais_nacimiento) "
                    + "values ('Lionel', 'Messi', 33, 0)";

            int pk = -1;

            try (PreparedStatement stmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS)) {
                stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        pk = rs.getInt(1);
                    }
                }
            }

            if (pk == -1) {
                throw new Exception("PK no ha sido generada.");
            }

            queryString = "insert into jugador_log (jugador_id, creadoel) "
                    + "values (" + pk + ", current_date)";

            try (PreparedStatement stmt = connection.prepareStatement(queryString)) {
                stmt.executeUpdate();
            }

            connection.commit();
        } catch (Exception ex) {
            connection.rollback();
            System.err.println("Error:  " + ex.getMessage());
        }
    }

    public void insertarJugadorLog(Connection connection) throws SQLException {
        String queryString = "insert into jugador_log (jugador_id, creado_el, creado_el_time ) "
                + "values (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(queryString)) {
            stmt.setInt(1, 9);
            /*
                java.util.Date utilDate = new java.util.Date();
                long time = utilDate.getTime();
                java.sql.Date creadoEl = new java.sql.Date(time);*/

            java.sql.Date creadoEl = java.sql.Date.valueOf(LocalDate.now());
            stmt.setDate(2, creadoEl);

            java.sql.Timestamp creadoElTime = java.sql.Timestamp.valueOf(LocalDateTime.now());
            stmt.setTimestamp(3, creadoElTime);

            stmt.executeUpdate();

        }
    }

    public List<Wrapper> getData(Connection connection) throws SQLException {

        List<Wrapper> wrapperList = new ArrayList<>();

        String queryString = "select \n"
                + "	j.id\n"
                + "	, j.nombre \n"
                + "	, j.apellido \n"
                + "	, jl.creado_el_time\n"
                + "from jugador_log as jl \n"
                + "inner join jugador as j on j.id = jl.jugador_id\n";
        //  + "where jl.jugador_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(queryString)) {

            //stmt.setInt(1, 6);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Wrapper wrapper = new Wrapper();
                    wrapper.setId(rs.getInt("id"));
                    wrapper.setNombre(rs.getString("nombre"));
                    wrapper.setApellido(rs.getString("apellido"));
                    wrapper.setCreadoElTime(rs.getTimestamp("creado_el_time"));
                    wrapperList.add(wrapper);

                }
            }
        }

        return wrapperList;
    }

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mariadb://localhost:3306/db1C2021";
//        String url = "jdbc:postgresql://localhost:5432/db1C2021_psql";

        try (Connection connection = DriverManager.getConnection(url, "root", "felicia")) {

            connection.setAutoCommit(true);

            Main main = new Main();
            List<Wrapper> wrapperList = main.getData(connection);
            wrapperList.stream().forEach(System.out::println);

        }
    }
}
