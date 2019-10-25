<%-- 
    Document   : Editar
    Created on : 25/10/2019, 10:01:45 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-5">
            <div class="card border border-info">
                <div class="card-header">
                    <div class="card-body">
                        <h5 class="card-title">Editar Empleado</h5>
                        <form method="POST" action="Editar.htm">
                            <div class="form-group">
                              <label for="clave">Clave</label>
                              <input type="number" class="form-control" name="clave" id="clave" placeholder="Ingrese la clave del emplado" value="${lista[0].clave}" readonly>
                            </div>
                            <div class="form-group">
                              <label for="nombre">Nombre</label>
                              <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre del emplado" value="${lista[0].nombre}" required>
                            </div>
                            <div class="form-group">
                              <label for="sueldo">Sueldo</label>
                              <input type="number" class="form-control" name="sueldo" id="sueldo" placeholder="Ingrese el sueldo del emplado" value="${lista[0].sueldo}" required>
                            </div><br>
                            <center>
                                <a class="btn btn-secondary" href="Ver.htm?clave=${lista[0].clave}" style="margin-right: 50px;">Regresar</a>
                                <button type="submit" class="btn btn-success">Guardar</button>
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
