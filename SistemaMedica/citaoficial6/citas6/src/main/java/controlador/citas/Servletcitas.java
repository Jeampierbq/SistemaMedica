/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.citas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Especialidad;
import modelo.bean.Fecha;
import modelo.bean.Horario;
import modelo.bean.Medico;
import modelo.bean.Paciente;
import modelo.bean.Usuario;
import modelo.dao.CitaDAO;
import modelo.dao.EspecialidadDAO;
import modelo.dao.FechaDAO;
import modelo.dao.HorarioDAO;
import modelo.dao.MedicoDAO;
import modelo.dao.PacienteDAO;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author Jeampier
 */
@WebServlet(name = "Servletcitas", urlPatterns = {"/Servletcitas", "/citas", "/inicio", "/usuarios", "/especialidades", "/medicos", "/pacientes","/horarios"})
public class Servletcitas extends HttpServlet {

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
            //citas
            String path = request.getServletPath();
            ArrayList<Usuario> usuarios = UsuarioDAO.listarUsuarios();
            ArrayList<Horario> horarios = HorarioDAO.listarHorarios();
            ArrayList<Fecha> fechas = FechaDAO.listarFechas();
            ArrayList<Paciente> pacientes = PacienteDAO.listarPacientes();
            ArrayList<Medico> medicos = MedicoDAO.listarMedicos();
            ArrayList<Especialidad> especialidades = EspecialidadDAO.listarEspecialidades();
            if (path.equals("/inicio")) {
                request.setAttribute("pacientes", PacienteDAO.listarPacientes());
                request.getRequestDispatcher("WEB-INF/menuinicio.jsp").forward(request, response);
            }
            if (path.equals("/citas")) {
                request.setAttribute("pacientes", PacienteDAO.listarPacientes());
                request.setAttribute("medicos", MedicoDAO.listarMedicos());
                request.setAttribute("especialidades", EspecialidadDAO.listarEspecialidades());
                request.setAttribute("horarios", HorarioDAO.listarHorarios());
                request.setAttribute("fechas", FechaDAO.listarFechas());
                request.setAttribute("usuarios", UsuarioDAO.listarUsuarios());
                request.setAttribute("citas", CitaDAO.listarCitas());
                
                
                request.getRequestDispatcher("WEB-INF/menucitas.jsp").forward(request, response);
            }
            if (path.equals("/usuarios")) {
                request.setAttribute("usuarios", UsuarioDAO.listarUsuarios());
                request.getRequestDispatcher("WEB-INF/menusuario.jsp").forward(request, response);
            }
            if (path.equals("/especialidades")) {
                request.setAttribute("especialidades", EspecialidadDAO.listarEspecialidades());
                request.getRequestDispatcher("WEB-INF/menuespecilidades.jsp").forward(request, response);
            }
            if (path.equals("/medicos")) {
                request.setAttribute("medicos", MedicoDAO.listarMedicos());
                request.setAttribute("especialidades", EspecialidadDAO.listarEspecialidades());
                request.getRequestDispatcher("WEB-INF/menumedico.jsp").forward(request, response);
            }
            if (path.equals("/pacientes")) {
                 request.setAttribute("pacientes", PacienteDAO.listarPacientes());
                request.getRequestDispatcher("WEB-INF/menupaciente.jsp").forward(request, response);
            }
            if (path.equals("/horarios")) {
                request.setAttribute("horarios", HorarioDAO.listarHorarios());
                request.getRequestDispatcher("WEB-INF/menuhorario.jsp").forward(request, response);
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
