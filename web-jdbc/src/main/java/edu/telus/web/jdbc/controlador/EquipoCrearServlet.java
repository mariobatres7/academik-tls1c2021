package edu.telus.web.jdbc.controlador;

import edu.telus.web.jdbc.modelo.Equipo;
import edu.telus.web.jdbc.servicio.EquipoServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "EquipoCrearServlet", urlPatterns = {"/crear-equipo.html"})
public class EquipoCrearServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("mensaje", "");
        
        request.getRequestDispatcher("equipos/crear-equipo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Equipo equipo = new Equipo();
            equipo.setDireccion(request.getParameter("direccion"));
            equipo.setNombre(request.getParameter("nombre"));

            EquipoServicio equipoServicio = new EquipoServicio();
            equipoServicio.crear(equipo);
            
            request.setAttribute("mensaje", "Equipo con ID = " + equipo.getId() + " creado satifactoriamente.");
            
            request.getRequestDispatcher("equipos/crear-equipo.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
