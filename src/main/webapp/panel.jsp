<%-- 
    Document   : panel
    Created on : 5/08/2024, 12:54:03 a. m.
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
        <title>JSP Page</title>
    </head>
    <body>

        <%
            if (session.getAttribute("correo") == null) {
                response.sendRedirect("index.html");
                return;
            }

        %>
        
        <main class="container">
            <h1>Registro exitoso</h1>
        </main>

    </body>
</html>
