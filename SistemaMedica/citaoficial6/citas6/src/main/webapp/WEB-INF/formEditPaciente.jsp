<%-- 
    Document   : formEditPaciente
    Created on : 11 dic. 2023, 17:38:15
    Author     : Jeampier
--%>

<%@page import="modelo.bean.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            background-image: url('https://i.pinimg.com/originals/db/aa/53/dbaa539d1307c0c9a6fc1800224e111b.png');
            background-repeat: no-repeat;
            background-size: 100%; /* Cubre toda la pantalla */
            margin: 0;
            padding: 0;
        }
    </style>
    <body>
        <div style="width: 30%;margin-left: 40%;margin-top: 15%; ">
            <h2>Editar Paciente</h2>
            <form action="grabarEdicionPaci" method="post">
                <%-- Obtener el objeto empleado del alcance de la solicitud --%>
                <% Paciente pacienteEditar = (Paciente) request.getAttribute("pacienteEditar"); %>

                <%-- Verificar si se encontró el paciente --%>
                <% if (pacienteEditar != null) {%>
                <label for="dni">DNI :</label>
                <input type="text" name="dni" value="<%= pacienteEditar.getDni()%>"><br>

                <label for="nom">NOMBRE :</label>
                <input type="text" name="nom" value="<%= pacienteEditar.getNombre()%>"><br>

                <label for="ap">APELLIDO :</label>
                <input type="text" name="ap" value="<%= pacienteEditar.getApellido()%>"><br>

                <label for="tel">TELEFONO :</label>
                <input type="text" name="tel" value="<%= pacienteEditar.getTelefono()%>"><br>

                <label for="sex">SEXO :</label>
                <input type="text" name="sex" value="<%= pacienteEditar.getSexo()%>"><br>

                <label for="gma">GMAIL :</label>
                <input type="text" name="gma" value="<%= pacienteEditar.getEmail()%>"><br>

                <input type="hidden" name="id" value="<%= pacienteEditar.getIdpaci()%>">

                <input type="submit" class="btn btn-primary" value="Guardar cambios">
                <% } else { %>
                <p>Paciente no encontrado.</p>
                <% }%>
            </form>
        </div>>
    </body>
</html>