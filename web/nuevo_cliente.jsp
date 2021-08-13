<%-- 
    Document   : login
    Created on : 14-Jul-2021, 22:31:19
    Author     : Ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="estilo_registro.css" rel="stylesheet" type="text/css"  />
        <title>Añadir cliente</title>
    </head>
    <body style="background-color: black">
        <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div style="margin-top:120px; background-color: black" id="login-box; overflow: hidden" class="col-md-12">
                        <form id="login-form" class="form" method="post" action="${pageContext.request.contextPath}/nuevoCliente">
                            <h1 style="font-family: Montserrat; color: white">Añade un cliente.</h1>
                            <hr style="background-color: #779E7B"></hr>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="nombre" >Nombre</label>
                                <br/>   
                                <input type="text" name="nombre" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="email" >Correo</label>
                                <br/>   
                                <input type="text" name="email" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="telefono" >Teléfono</label>
                                <br/>   
                                <input type="text" name="telefono" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="provincia" >Provincia</label>
                                <br/>   
                                <input type="text" name="provincia" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="poblacion" >Población</label>
                                <br/>   
                                <input type="text" name="poblacion" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="dni" >DNI</label>
                                <br/>   
                                <input type="text" name="dni" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>  
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="direccion" >Dirección</label>
                                <br/>   
                                <input type="text" name="direccion" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="codigopostal" >Código Postal</label>
                                <br/>   
                                <input type="text" name="codigopostal" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            
                            <div class="form-group" style="text-align:center; font-family: Montserrat;">
                                <button type="submit" value="Submit" class="btn hola" style="background-color: #779E7B; color: black; margin-top: 20px; border-radius: 0px">Finalizar</button>
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
