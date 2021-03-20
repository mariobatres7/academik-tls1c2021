package edu.academik.telus.jw1c2021.primerservlet.productos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "ProductoListadoServlet", urlPatterns = {"/producto-listado.html"})
public class ProductoListadoServlet extends HttpServlet{
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<String> productoList = new ArrayList();        
        productoList.add("cereal");
        productoList.add("cafe");
        productoList.add("leche");
        productoList.add("uvas");
        productoList.add("azúcar");
        productoList.add("agua");

        request.setAttribute("productoList", productoList);
        
        request.getRequestDispatcher("productos/producto-listado.jsp").forward(request, response);        
    }
    
}
