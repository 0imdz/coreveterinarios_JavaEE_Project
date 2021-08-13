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
        <title>Acceso a Intranet</title>
    </head>
    <body style="background-color: black">
        <div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div style="margin-top:150px; background-color: black" id="login-box" class="col-md-12">
                        <form id="login-form" class="form" method="post" action="${pageContext.request.contextPath}/productos">
                            <h1 style="font-family: Montserrat">Acceso a la plataforma.</h1>
                            <hr style="background-color: #779E7B"></hr>
                            <div class="form-group" style="text-align: left;">
                                <label style="margin-top: 10px; color: white; font-family: Montserrat" for="nombre" >Nombre de producto</label>
                                <br/>   
                                <input type="text" name="nombre" id="user-input" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;font-family: Montserrat">
                                <label style="margin-top: 10px; color: white" for="descripcion">Descripcion</label>
                                <br/>
                                <input type="text" name="descripcion" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" id="user-input" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;font-family: Montserrat">
                                <label style="margin-top: 10px; color: white" for="precio">Precio</label>
                                <br/>
                                <input type="text" name="precio" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" id="user-input" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;font-family: Montserrat">
                                <label style="margin-top: 10px; color: white" for="stock">Stock</label>
                                <br/>
                                <input type="text" name="stock" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" id="user-input" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align: left;font-family: Montserrat">
                                <label style="margin-top: 10px; color: white" for="id_tipoanimal">ID ANIMAL</label>
                                <br/>
                                <input type="text" name="id_tipoanimal" style="background-color: black; border-radius:0px; color: #779E7B; font-family: Montserrat" id="user-input" class="form-control" />
                            </div>
                            <div class="form-group" style="text-align:center; font-family: Montserrat;">
                                <button type="submit" value="Submit" class="btn hola" style="background-color: #779E7B; color: black; margin-top: 20px; border-radius: 0px">Finalizar</button>
                                <br>
                                <br>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
