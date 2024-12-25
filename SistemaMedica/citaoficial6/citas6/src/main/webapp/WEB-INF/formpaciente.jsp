<%-- 
    Document   : formpaciente
    Created on : 11 dic. 2023, 15:02:20
    Author     : Jeampier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
            <h2>Nuevo Paciente</h2>
            <form action="grabarPaci" method="post">
                <table>
                    <tr>
                        <td>DNI :</td>
                        <td><input type="text" name="dni"></td>
                    </tr>
                    <tr>
                        <td>NOMBRE :</td>
                        <td><input type="text" name="nom"></td>
                    </tr> 
                    <tr>
                        <td>APELLIDO :</td>
                        <td><input type="text" name="ap"></td>
                    </tr> 
                    <tr>
                        <td>TELEFONO :</td>
                        <td><input type="text" name="tel"></td>
                    </tr>
                    <tr>
                        <td>SEXO :</td>
                        <td><input type="text" name="sex"></td>
                    </tr>
                    <tr>
                        <td>GMAIL :</td>
                        <td><input type="text" name="gma"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" Value="Grabar" class="btn btn-primary"></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>
