<%-- 
    Document   : Eliminar
    Created on : 25/10/2019, 10:16:32 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <div class="card border border-info">
                <div class="card-header">
                    <div class="card-body">
                        <h3 class="card-title">Eliminar Empleado</h3><br>
                        <center><h5>¿Desea eliminar el empleado ${lista[0].nombre}?</h5></center>
                        <form method="POST" action="Eliminar.htm">
                            <div class="form-group">
                              <input type="hidden" class="form-control" name="clave" id="clave" placeholder="Ingrese la clave del emplado" value="${lista[0].clave}" readonly>
                            </div>
                            <center>
                                <a class="btn btn-secondary" href="index.htm" style="margin-right: 50px;">Regresar</a>
                                <button type="submit" class="btn btn-danger">Eliminar</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
