<%-- 
    Document   : Ver
    Created on : 25/10/2019, 10:26:31 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <div class="card border border-info">
                <div class="card-header">
                    <div class="card-body">
                        <h5 class="card-title">Datos del Empleado</h5>
                        <div class="form-group">
                          <label for="clave">Clave</label>
                          <input type="number" class="form-control" name="clave" id="clave" placeholder="Ingrese la clave del emplado" value="${lista[0].clave}" readonly>
                        </div>
                        <div class="form-group">
                          <label for="nombre">Nombre</label>
                          <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre del emplado" value="${lista[0].nombre}" readonly>
                        </div>
                        <div class="form-group">
                          <label for="sueldo">Sueldo</label>
                          <input type="number" class="form-control" name="sueldo" id="sueldo" placeholder="Ingrese el sueldo del emplado" value="${lista[0].sueldo}" readonly>
                        </div><br>
                        <center>
                            <a class="btn btn-secondary" href="index.htm" style="margin-right: 50px;">Regresar</a>
                            <a class="btn btn-info" href="Modificar.htm?clave=${lista[0].clave}">Editar</a>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
