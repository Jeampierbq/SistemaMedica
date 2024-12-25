<%-- 
    Document   : login
    Created on : 20 nov. 2023, 16:16:02
    Author     : Jeampier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%String msg = (String) request.getAttribute("msg");%>
        <div class="d-flex justify-content-center align-items-center" style="min-height: 100vh; flex-direction: column;">
            <img src="https://w7.pngwing.com/pngs/957/974/png-transparent-hospital-logo-clinic-health-care-physician-business.png" alt="Logo" style="max-width: 250px;">
            <form action="login" method="post" style="margin-top: 20px;">
                <h1>Iniciar Sesión</h1>
                <div class="form-group">
                    <label for="usuario" class="form-label">Usuario</label>
                    <input type="text"  name="us" class="form-control" id="usuario" aria-describedby="emailHelp"  placeholder="Usuario o Correo electronico">       
                </div>
                <div class="form-group">                
                    <label for="contraseña" class="form-label">Password</label>
                    <input type="password" name="ps" class="form-control" id="contraseña" placeholder="Contraseña"></div>
                <div class="mb-3 form-check">
                    <span id="msg"><%=msg != null ? msg : ""%></span>
                </div>
                <button type="submit" class="btn btn-primary">Sing in</button>
            </form>
            <p class="mt-3" style="color: white;">¿No tienes una cuenta? <a href="regi" style="color: white;">Regístrate aquí</a></p>  
        </div>
    </body>
</html>
