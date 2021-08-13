<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
            <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            <link href="estilo_perfil.css" rel="stylesheet">
            <link href="estilo_registro.css" rel="stylesheet">
            <link href="estilo_registro_alta.css" rel="stylesheet">
            <link rel="shortcut icon" href="/huella.png">
            <title>Perfil</title>
            
            <!------ Include the above in your HEAD tag ---------->
        </head>
        
        <body style="background-color: black; color: black">
            <div class="container" style="margin-top: 30px">
                <div class="row">
                    <div class="span12">
                        <div class="head">
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="span6">
                                        <h1 style="font-family: Montserrat; color: #8dcc8d"><a href="${pageContext.request.contextPath}/perfil/" style="text-decoration: none; color: #8dcc8d">Bienvenido, ${sessionScope.usuario.nombre}.</a></h1>
                                    </div>
                                    <div class="" style="margin-top:15px;">
                                        <button style="background-repeat: no-repeat;background-image: none;color: blue;text-shadow: none;background-color: transparent;border-color: transparent;border: none;box-shadow: none;background-image: none;background-image: none;background-color: black; border: 1px solid #4a4a4a; color: white; margin-top: 9px; border-radius: 0px" class="btn pull-right"><a href="${pageContext.request.contextPath}/login?salir" style="text-decoration: none; color: white; font-family: Montserrat">SALIR</a></button>
                                    </div>
                                </div>
                            </div>

                            <div class="navbar" style="text-shadow: none">
                                <div class="container" style="background-color: black; border: 1px solid #4a4a4a">
                                    <ul class="nav">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/perfil/clientes" style="color: white; text-decoration: none; font-family: Montserrat; text-shadow: none">Clientes</a>
                                        </li>

                                        <li>
                                            <a href="${pageContext.request.contextPath}/perfil/animales" style="color: white; text-decoration: none; font-family: Montserrat; text-shadow: none">Animales</a>
                                        </li>

                                        <li>
                                            <a href="${pageContext.request.contextPath}/perfil/productos" style="color: white; text-decoration: none; font-family: Montserrat; text-shadow: none">Productos</a>
                                        </li>
                                    </ul>
                                    <div style="text-align: right; margin-top: 7px; margin-right: 17px">
                                        <a href="#" type="submit" onclick="mostrarFormulario()" style="cursor: pointer; color: white; text-decoration: none; font-family: Montserrat; text-shadow: none; font-size: 50px;">+</a>    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                                        
                <div id="indicacion" style="text-align: center">
                    <p style="font-family: Montserrat; color: #8dcc8d">Clique sobre un elemento de la barra de navegación para consultar información o añadir un elemento.</p>
                </div>

                
                    <div id="formulario" class="well span11 offset adios_border" style="display: none; background-color: black; border-radius: 0px; font-family: Montserrat; color: white; text-align: center; border: 0px">
                        <div id="login-row" class="row justify-content-center align-items-center">
                            <div id="login-column" class="col-md-6">
                                <div style="background-color: black" id="login-box; overflow: hidden" class="col-md-12">
                                      <h1 style="font-family: Montserrat; margin-bottom:36px">Añadir elemento.</h1>  
                                        <div class="form-group">
                                            <label style="margin-top: 10px; color: white; font-family: Montserrat" for="username" >¿Qué elemento desea añadir?</label>
                                            <br/>   
                                            <div style="margin-bottom: 40px">
                                                <button type="submit" style="color: black; margin-top: 1px; border-radius: 0px" class="btn nuevo"><a href="/coreveterinarios/nuevo_animal.jsp" style="text-decoration: none; color: black">Mascota</a></button>
                                                <button type="submit" style="color: black; margin-top: 1px; border-radius: 0px" class="btn nuevo"><a href="/coreveterinarios/nuevo_cliente.jsp" style="text-decoration: none; color: black">Cliente</a></button>
                                                <button type="submit" style="color: black; margin-top: 1px; border-radius: 0px" class="btn nuevo"><a href="/coreveterinarios/nuevo_producto.jsp" style="text-decoration: none; color: black">Producto</a></button>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>  
                                        
                
                                        
                <div id="clientela">
                <c:forEach items="${clientesList}" var="cliente">
                    <div class="well span11 offset" style="background-color: black; border-radius: 0px; border: 1px solid #8dcc8d; font-family: Montserrat">
                        <div class="row-fluid user-row">
                            <div class="span12" style="color: white; text-align: center; margin-bottom: 10px">
                                <h1>${cliente.nombre}</h1>
                                <span class="text-muted">Correo: ${cliente.email}</span><br>
                                <span class="text-muted">Teléfono: ${cliente.telefono}</span><br>
                            </div>
                        </div>
                    </div>
                                
                </c:forEach>
                </div>
                                        
                
                                        
                <div id="animales">
                <c:forEach items="${animalesList}" var="animal">
                    <div class="well span11 offset" style="background-color: black; border-radius: 0px; border: 1px solid #8dcc8d; font-family: Montserrat">
                        <div class="row-fluid user-row">
                            <div class="span12" style="color: white; text-align: center">
                                <h1>${animal.nombre}</h1>
                                <span class="text-muted">Peso del animal: ${animal.peso_gramos} Kg</span><br>
                                
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
                                        
                <div id="productos">                        
                <c:forEach items="${productosList}" var="producto">
                    <div class="well span11 offset" style="background-color: black; border-radius: 0px; border: 1px solid #8dcc8d; font-family: Montserrat">
                        <div class="row-fluid user-row">
                            <div class="span12" style="color: white; text-align: center">
                                <h1>${producto.nombre}</h1>
                                <span class="text-muted">Descripción: ${producto.descripcion}</span><br>
                                <span class="text-muted">Stock: ${producto.stock} unidad(es)</span><br>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </body>
        <script type="text/javascript">
            function mostrarFormulario(){
                document.getElementById("formulario").style.display="block";
                document.getElementById("clientela").style.display="none";
                document.getElementById("animales").style.display="none";
                document.getElementById("productos").style.display="none";
                document.getElementById("indicacion").style.display="none";
               
            }
            
        </script>
    </html>
