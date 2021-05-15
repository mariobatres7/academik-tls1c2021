<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="edu.telus.web.jdbc.modelo.Equipo"%>
<%
    List<Equipo> equipoList = (List<Equipo>) request.getAttribute("equipoList");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebJDBC:  Listado de Equipos</title>
    </head>
    <body>
        <h1>Listado de Equipos</h1>

        <div>            
            <table>

                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                    for (Equipo equipo : equipoList) {%>
                    <tr>
                        <td><%=equipo.getId()%></td>
                        <td><%=equipo.getNombre()%></td>
                        <td><%=equipo.getDireccion()%></td>
                    </tr>
                    <%}%>
                </tbody>                
            </table>            
        </div>
    </body>
</html>
