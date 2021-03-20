<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola desde JSP Page</title>

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                alert("Bienvenido !!!!");
                // asdfasdfasdf

            <%
                    //Comentario
                    /*Comentarios*/
                    String var1 = "abc";
                    out.println("alert('" + var1.toUpperCase() + "');");
            %>

            });
        </script>

        <style type="text/css">
            h1 {
                font-size: 20px;
                text-align: center;                
            }
            
            div {
                width: 50%;
                border: 2px solid blue;
                margin-left: 25%;
            }
        </style>

    </head>

    <body>

        <!-- comentario en html -->

        <h1>Hola desde JSP Page</h1>

        <%
            String str = "Variable string";
            out.println("Hola variable:  " + str);

            ArrayList<Integer> integerArrayList = new ArrayList();

            for (int i = 0; i < 200; i++) {
                integerArrayList.add(i);
            }

            out.println("<ul>");

            for (Integer item : integerArrayList) {
        %>
    <li>Item: <b> <%=item%> </b> </li>
        <%
            }
            out.println("</ul>");
        %>        

    <div>
        <%
        
            String param = request.getParameter("param");
            
            if (param != null){
            
                %>
                <strong>El paramatero es:  <%=param%></strong>
                <%
            }
        %>
    </div>        


</body>
</html>
