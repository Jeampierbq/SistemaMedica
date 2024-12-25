/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.paciente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Paciente;
import modelo.dao.PacienteDAO;

/**
 *
 * @author Jeampier
 */
@WebServlet(name = "ServletEmpleado", urlPatterns = {"/ServletEmpleado", "/nuevoPaci", "/grabarPaci", "/editarPaci", "/grabarEdicionPaci", "/eliminarPaci"})
public class ServletPaciente extends HttpServlet {

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
            if (path.equals("/nuevoPaci")) {
                // Acción: Redireccionar al formulario para agregar nuevo empleado
                request.getRequestDispatcher("WEB-INF/formpaciente.jsp").forward(request, response);
            }
            if (path.equals("/grabarPaci")) {
                //Capturar datos del formulario
                String dni = request.getParameter("dni");
                String nom = request.getParameter("nom");
                String ap = request.getParameter("ap");
                String tel = request.getParameter("tel");
                String sex = request.getParameter("sex");
                String gma = request.getParameter("gma");
                //ecapslar datos en el objeto empleado
                Paciente paci = new Paciente(0, dni, nom, ap, tel, sex, gma);
                PacienteDAO.insertar(paci);
                //direccionar a la tabla 
                response.sendRedirect("/citas/pacientes");

            }
            if (path.equals("/editarPaci")) {
                // Capturar valor de id que viene por la URL
                int id = Integer.parseInt(request.getParameter("id"));

                // Buscar el empleado por ID
                Paciente pacienteEditar = PacienteDAO.buscarPacienteID(id);

                // Verificar si se encontró el empleado
                if (pacienteEditar != null) {
                    // Poner el empleado en el alcance de solicitud para que el formulario pueda acceder a sus datos
                    request.setAttribute("pacienteEditar", pacienteEditar);

                    // Redireccionar al formulario de edición
                    request.getRequestDispatcher("/WEB-INF/formEditPaciente.jsp").forward(request, response);
                } else {
                    // Manejar el caso en el que no se encuentra el empleado
                    response.sendRedirect("/citas/pacientes");
                }
            }
            if (path.equals("/grabarEdicionPaci")) {
                String dni = request.getParameter("dni");
                String nom = request.getParameter("nom");
                String ap = request.getParameter("ap");
                String tel = request.getParameter("tel");
                String sex = request.getParameter("sex");
                String gma = request.getParameter("gma");
                int id = Integer.parseInt(request.getParameter("id"));

                // Crear un objeto Paciente con los nuevos datos
                Paciente paciEditado = new Paciente(id, dni, nom, ap, tel, sex, gma);
                // Actualizar el empleado en la base de datos
                PacienteDAO.modificarPaciente(paciEditado);

                // Redireccionamiento a la lista de empleados
                response.sendRedirect("/citas/pacientes");
            }
            if (path.equals("/eliminarPaci")) {
                //capturar valode de id que viene por la url
                int id = Integer.parseInt(request.getParameter("id"));
                //eliminar de la base de datos 
                PacienteDAO.eliminar(id);
                response.sendRedirect("/citas/pacientes");
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
