package edu.telus.segundoservlet.controlador;

import edu.telus.segundoservlet.servicio.PaisServicio;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "PaisServletControlador", urlPatterns = {"/pais.html"})
public class PaisServletControlador extends HttpServlet {

    private final PaisServicio paisServicio = new PaisServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var paisList = this.paisServicio.buscarPaises();

        request.setAttribute("paisList", paisList);
        request.setAttribute("currentDate", new Date());

        request.getRequestDispatcher("pais-jstl.jsp").forward(request, response);
    }

}
