package edu.academik.telus.jw1c2021.primerservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario Batres
 */
@WebServlet(name = "HolaServlet", urlPatterns = {"/hola"})
public class HolaServlet extends HttpServlet {

    private ArrayList<Integer> integerArrayList;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.integerArrayList = new ArrayList();
        
        for (int i = 0; i < 200; i++) {
            integerArrayList.add(i);
        }
        
        Automovil automovil = new Automovil();
        automovil.setMarca("Toyota");
        automovil.setLinea("Corolla");
        automovil.setPrecio(30000);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HolaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HolaServlet at " + request.getContextPath() + "</h1>");

            out.println("<ul>");
            
            for (Integer item : this.integerArrayList) {
                out.println("<li>Item:  " + item + " </li>");
            }

            out.println("</ul>");

            out.println("<div>");
            out.println("<h2>Automóvil</h2>");
            out.println("<p><strong>Marca: </strong>" + automovil.getMarca() + "</p>");
            out.println("<p><strong>Línea: </strong>" + automovil.getLinea()+ "</p>");
            out.println("<p><strong>Precio: </strong>" + automovil.getPrecio() + "</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Hola desde GET");
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Hola desde POST");
                
        processRequest(request, response);
    }*/

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
