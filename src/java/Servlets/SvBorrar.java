/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
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
@WebServlet(name = "SvBorrar", urlPatterns = {"/SvBorrar"})
public class SvBorrar extends HttpServlet {

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
                        int id= Integer.parseInt(request.getParameter("dni")); 
                 int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
                Controladora control = new Controladora();
        try {
            control.BorrarEmpleado(id,idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvBorrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("ListaEmpleados", control.TraerEmpleados());
        response.sendRedirect("listaEmpleados.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
