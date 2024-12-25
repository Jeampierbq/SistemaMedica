/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Usuario;
import modelo.dao.PacienteDAO;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author Jeampier
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario", "/login", "/regi", "/cerrarsesion", "/nuevousu", "/grabarusu", "/editarUsu", "/grabarEdicionUsu"})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String path = request.getServletPath();

            if (path.equals("/login")) {
                // Capturar datos del usuario
                String us = request.getParameter("us");
                String ps = request.getParameter("ps");

                // Validar usuario y redirigir 
                Usuario usuario = UsuarioDAO.validarUsuario(us, ps);

                // Si el usuario existe en la base de datos 
                if (usuario != null) {
                    request.setAttribute("usuario", us);
                    request.setAttribute("pacientes", PacienteDAO.listarPacientes());
                    request.getRequestDispatcher("WEB-INF/menu.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg", "Usuario y/o contraseña incorrectos");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }

            // Para registrarse nuevo usuario
            if (path.equals("/regi")) {
                request.getRequestDispatcher("WEB-INF/createlogin.jsp").forward(request, response);
            }
            if (path.equals("/cerrarsesion")) {
                //cerrar variable de sesion
                request.getSession().invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (path.equals("/nuevousu")) {
                // Acción: Redireccionar al formulario para agregar nuevo usuario
                request.getRequestDispatcher("WEB-INF/formusuario.jsp").forward(request, response);
            }
            if (path.equals("/grabarusu")) {
                //Capturar datos del formulario
                String nom = request.getParameter("nom");
                String ap = request.getParameter("ap");
                String sex = request.getParameter("sex");
                String dni = request.getParameter("dni");
                String gma = request.getParameter("gma");
                String pasw = request.getParameter("pasw");
                Usuario usu = new Usuario(0, nom, ap, sex, dni, gma, pasw);
                UsuarioDAO.insertar(usu);
                //direccionar a la tabla 
                response.sendRedirect("/citas/usuario");
            }
            if (path.equals("/editarUsu")) {
                // Capturar valor de id que viene por la URL
                int id = Integer.parseInt(request.getParameter("id"));

                // Buscar el empleado por ID
                Usuario usuarioEditar = UsuarioDAO.buscarUsuarioID(id);

                // Verificar si se encontró el empleado
                if (usuarioEditar != null) {
                    // Poner el usuario en el alcance de solicitud para que el formulario pueda acceder a sus datos
                    request.setAttribute("usuarioEditar", usuarioEditar);

                    // Redireccionar al formulario de edición
                    request.getRequestDispatcher("/WEB-INF/formuEditUsuario.jsp").forward(request, response);
                } else {
                    // Manejar el caso en el que no se encuentra el empleado
                    response.sendRedirect("/citas/usuario");
                }
            }
            if (path.equals("/grabarEdicionUsu")) {
                String nom = request.getParameter("nom");
                String ap = request.getParameter("ap");
                String sex = request.getParameter("sex");
                String dni = request.getParameter("dni");
                String gma = request.getParameter("gma");
                String pasw = request.getParameter("pasw");
                int id = Integer.parseInt(request.getParameter("id"));

                // Crear un objeto Paciente con los nuevos datos
                Usuario usuEditado = new Usuario(id, nom, ap, sex, dni, gma, pasw);
                // Actualizar el empleado en la base de datos
                UsuarioDAO.modificar(usuEditado);

                // Redireccionamiento a la lista de empleados
                response.sendRedirect("/citas/usuario");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
