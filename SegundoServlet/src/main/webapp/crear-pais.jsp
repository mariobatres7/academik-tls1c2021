<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Pais</title>
    </head>
    <body>
        <h1>Crear Pais</h1>

        <form action="crear-pais.html" method="POST">

            <label>Nombre:</label> 
            <input type="text" name="nombre" id="nombre" required="true" />

            <label>Ranking:</label>
            <input type="number" name="ranking1" required="true" />

            <input type="submit" value="Enviar" />

        </form>

        <% if (request.getAttribute("respuesta") != null) {%>
        <div><%=request.getAttribute("respuesta")%></div>
        <%}%>
    </body>
</html>
