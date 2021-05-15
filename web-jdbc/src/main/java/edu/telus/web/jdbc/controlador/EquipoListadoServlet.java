package edu.telus.web.jdbc.controlador;

import edu.telus.web.jdbc.modelo.Equipo;
import edu.telus.web.jdbc.servicio.EquipoServicio;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "EquipoListadoServlet", urlPatterns = {"/equipos.html"})
public class EquipoListadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EquipoServicio equipoServicio = new EquipoServicio();

            List<Equipo> equipoList = equipoServicio.buscarEquipos();

            request.setAttribute("equipoList", equipoList);

            request.getRequestDispatcher("equipos/equipos-listado.jsp").forward(request, response);

        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
