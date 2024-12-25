<%-- 
    Document   : menusuario
    Created on : 11 dic. 2023, 01:36:20
    Author     : Jeampier
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/inicio.css">
        <title>Clinica</title>
    </head>
    <style>
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 80px;
            background: url('https://img.freepik.com/foto-gratis/fondo-azul-degradado-lujo-abstracto-azul-oscuro-liso-banner-estudio-vineta-negra_1258-54050.jpg') no-repeat center center fixed;
            background-size: cover;
            padding: 0 1200px; /* Añade un relleno a los lados para separar el contenido de los bordes */
        }

        header a {
            color: white; /* Color del texto */
            text-decoration: none; /* Elimina el subrayado del enlace */
            display: flex;
        }

        header .cerrar-sesion {
            margin-left: 10px; /* Ajusta el margen izquierdo según sea necesario */
        }

        h3 {
            text-align: center;

            font-family: 'Your Desired Font', sans-serif; /* Cambia 'Your Desired Font' por la fuente que prefieras */
            /* Puedes ajustar otros estilos según tus preferencias, por ejemplo: */
            font-size: 2em;
            letter-spacing: 2px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        aside {
            width: 250px;
            height: 643px;
            background: url('https://img.freepik.com/foto-gratis/fondo-azul-degradado-lujo-abstracto-azul-oscuro-liso-banner-estudio-vineta-negra_1258-54050.jpg') no-repeat center center fixed;
            background-size: cover;
            float: left;
            margin-top: 1px; /* Ajusta este valor según sea necesario */
        }

        #contenido {
            width: 1200px; /* Ajusta este valor según sea necesario */
            height: 640px;
            background: url('https://previews.123rf.com/images/taniascamera/taniascamera2103/taniascamera210300038/165616881-female-doctor-in-white-uniform-forms-a-heart-shape-with-her-hands-minimal-on-blue-background-banner.jpg') no-repeat center center fixed;
            background-size: cover;
            float: right;
            margin-top: 3px; /* Puedes ajustar este valor según sea necesario */
        }

        body{


        }
        .col-md-3.menu-izquierdo {
            margin: 0; /* Elimina el margen para ajustar mejor al aside */
        }

        .col-md-3.menu-izquierdo ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .col-md-3.menu-izquierdo li {
            width: 100%;
        }

        .col-md-3.menu-izquierdo li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .col-md-3.menu-izquierdo li a:hover {
            background-color: black;
        }
        .menu2 .mi-tabla {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 200px 0 0 5px; /* Agrega margen de 20px arriba y 20px a la izquierda */
            width: 90%; /* Ajusta el ancho según tus necesidades */

        }
    </style>
    <script>
        function confirmar() {
            if (confirm("Esta seguro de eliminar empleado?")) {
                return true;
            }
            return false;
        }
    </script>
    <body>
        <header>
            <a href="cerrarsesion">Cerrar sesion</a>
        </header>

        <aside>
            <div class="col-md-3 menu-izquierdo">
                <ul style="margin-top: 70px;">
                    <br><li><a href="inicio">Inicio</a></li>
                    <li><a href="citas">Citas</a></li>
                    <li><a href="usuarios">Usuarios</a></li>
                    <li><a href="especialidades">Especialidades</a></li>
                    <li><a href="medicos">Medicos</a></li>
                    <li><a href="pacientes">Pacientes</a></li>
                    <li><a href="horarios">Horarios</a></li>
                </ul>
            </div>
        </aside>

        <div id="contenido">
            <!-- Código de la tabla de usuarios -->
            <div class="menu2">
                <div class="col-md-7 mi-tabla pacientes">
                    <h3>Módulo de Usuarios</h3>
                    <% ArrayList<Usuario> usus = (ArrayList<Usuario>) request.getAttribute("usuarios"); %>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" style="background:cornsilk;">ID Usuario</th>
                                <th scope="col" style="background:cornsilk;">Nombres</th>
                                <th scope="col" style="background:cornsilk;">Apellido</th>
                                <th scope="col" style="background:cornsilk;">Gmail</th>

                            </tr>
                        </thead>
                        <tbody>
                            <% for (Usuario u : usus) {%>
                            <tr>
                                <th scope="row"> <%=u.getIdusuario()%> </th>
                                <td> <%=u.getNombre()%> </td>
                                <td> <%=u.getApellido()%> </td>
                                <td> <%=u.getGmail()%> </td>
                                <td>  </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>


