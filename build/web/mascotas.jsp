  
<%-- 
    Document   : clientes
    Created on : 30-jun-2021, 12:48:30
    Author     : portatilmsi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Animales</title>
    </head>
    <body>
        <h1>Listado de animales</h1>
        <ul>
            <c:forEach items="${animales}" var="animal">
                <li>${animal}</li>
            </c:forEach>
        </ul>
        <form action="Mascotas" method="POST">
            <input name="filtro" id="filtro" type="text" />
            <input type="submit" id="filtro" value="Enviar"/>
        </form>
    </body>
</html>