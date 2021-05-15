<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebJDBC:  ERROR</title>
    </head>
    <body>
        <h1>¡ERROR!</h1>

        <div><%=request.getAttribute("error")%></div>
    </body>
</html>
