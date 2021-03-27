package edu.telus.segundoservlet.controlador;

import edu.telus.segundoservlet.modelo.Pais;
import edu.telus.segundoservlet.servicio.PaisServicio;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PaisCreadorServletControlador", 
        urlPatterns = {"/crear-pais.html"})
public class PaisCreadorServletControlador extends HttpServlet {

    private PaisServicio paisServicio = new PaisServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("crear-pais.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String[] array = {"nombre", "ranking"};

            for (String parametro : array) {
                if (!request.getParameterMap().containsKey(parametro)) {
                    throw new RuntimeException(parametro + " es obligatorio.");
                } else {
                    if (request.getParameter(parametro).isEmpty() || request.getParameter(parametro).isBlank()) {
                        throw new RuntimeException(parametro + " está vacío.");
                    }
                }
            }

            Pais pais = new Pais();
            pais.setNombre(request.getParameter("nombre"));
            pais.setRanking(Double.parseDouble(request.getParameter("ranking")));

            paisServicio.agregarPais(pais);

            request.setAttribute("respuesta", "País agregado satisfactoriamente.");

            request.getRequestDispatcher("crear-pais.jsp").forward(request, response);

        } catch (RuntimeException ex) {

            if (ex instanceof NumberFormatException) {
                request.setAttribute("respuesta", "Número no válido.");
            } else {
                request.setAttribute("respuesta", ex.getMessage());
            }            
            response.sendRedirect(request.getContextPath()+ "/error.html");
        }

    }

}
