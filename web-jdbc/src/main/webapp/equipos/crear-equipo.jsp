<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebJDBC:  Crear Equipo</title>
    </head>
    <body>
        <h1>Crear Equipo</h1>

        <div><%=request.getAttribute("mensaje")%></div>

        <form action="crear-equipo.html" method="post">

            <label>Nombre:  </label>
            <input type="text" name="nombre" value="" required/>
            <br/>

            <label>Dirección:  </label>
            <input type="text" name="direccion" value="" required/>
            <br/>

            <input type="submit" value="Guardar" />
            <br/>

        </form>
    </body>
</html>
