/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Modelo.Habitacion;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Britos
 */
@WebServlet(name = "SvBorrarReserva", urlPatterns = {"/SvBorrarReserva"})
public class SvBorrarReserva extends HttpServlet {

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
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                  int idReserva= Integer.parseInt(request.getParameter("idReserva")); 
                 int idHabitacion= Integer.parseInt(request.getParameter("habitacion"));
                Controladora control = new Controladora();
        try {
            control.BorrarReserva(idReserva);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvBorrarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
                Habitacion hab = control.BuscarHabitacion(idHabitacion);
                hab.setOcupado(false);
        try {
            control.EditarHabitacion(hab);
        } catch (Exception ex) {
            Logger.getLogger(SvBorrarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("ListaReservas", control.TraerEmpleados());
        response.sendRedirect("listaReservas.jsp");
        
        
        
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
