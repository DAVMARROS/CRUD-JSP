<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Hackaton</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="container mt-5">
            <div class="card border border-info">
                <div class="card-header">
                    <a class="btn btn-primary" href="Nuevo.htm">Agregar Empleado</a>
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Clave</th>
                                    <th>Nombre</th>
                                    <th>Sueldo</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="reg" items="${lista}">
                                    <tr>
                                        <td>${reg.clave} </td>
                                        <td>${reg.nombre} </td>
                                        <td>${reg.sueldo} </td>
                                        <td> 
                                            <a class="btn btn-info" href="Ver.htm?clave=${reg.clave}" style="margin-left: 20px;">Ver</a>
                                            <a class="btn btn-warning" href="Modificar.htm?clave=${reg.clave}" style="margin-left: 20px;">Editar</a>
                                            <a class="btn btn-danger" href="Borrar.htm?clave=${reg.clave}" style="margin-left: 20px;">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
