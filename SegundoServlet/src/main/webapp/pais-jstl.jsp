
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Paises</title>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Listado de Paises</h1>

        <h2>JSTL</h2>

        <table class="table table-dark"> 

            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Ranking</th>
                </tr>
            </thead>
            <tbody>                                
                <c:forEach items="${paisList}" var="pais">
                    <tr>
                        <td><c:out value="${pais.id}" /></td>
                        <td><c:out value="${pais.nombre}" /></td>
                        <td>                            
                            <fmt:formatNumber value="${pais.ranking}" pattern="'R' #,##0.000" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        
        <div>
            <h3>Fecha Actual:  </h3>
            <span>
                <fmt:formatDate value="${currentDate}" pattern="dd-MM-yyyy HH:mm:ss" />                
            </span>
        </div>
    </body>
</html>
