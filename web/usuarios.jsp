<%-- 
    Document   : usuarios
    Created on : 01-Jul-2021, 13:00:52
    Author     : Ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>
        <ul>
            <c:forEach items="${usuarios}" var="usuario">
                <li>${usuario}</li>
            </c:forEach>
        </ul>
        <form action="usuarios" method="POST">
            <input name="filtro" id="filtro" type="text" />
            <input type="submit" id="filtro" value="Enviar"/>
        </form>
    </body>
</html>
