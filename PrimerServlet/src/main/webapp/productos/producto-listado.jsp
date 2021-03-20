<%-- 
    Document   : listado
    Created on : Mar 13, 2021, 11:39:00 AM
    Author     : Mario Batres
--%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<String> productoList = (List<String>) request.getAttribute("productoList");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Productos</title>
    </head>
    <body>
        <h1>Listado de Productos</h1>

        <table>
            <thead>
                <tr>
                    <th>Nombre del Producto</th>
                </tr>
            </thead>

            <tbody>
                <%
                    for (String item : productoList) {
                        out.println("<tr><td>" + item + "</td></tr>");    
                    }
                %>              
            </tbody>
        </table>
    </body>
</html>
