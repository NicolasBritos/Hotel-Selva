/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Modelo.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Britos
 */
@WebServlet(name = "SvNewEmpleado", urlPatterns = {"/SvNewEmpleado"})
public class SvNewEmpleado extends HttpServlet {

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
       //traer datos
          String dniString = request.getParameter("dni");
        int dni =Integer.parseInt(dniString);
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter ("nombre");
        String fechaNacString = request.getParameter ("fechaNac");
        Date fechaNac = new Date();
        try {  
           fechaNac=new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacString);
        } catch (ParseException ex) {
            Logger.getLogger(SvValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");
         String usuario = request.getParameter("usuario");
        String password = request.getParameter("password"); 
        Controladora controladora = new Controladora ();
        controladora.CrearUsuario(usuario,password);
        Usuario user = new Usuario();
        try {
            user = controladora.UltimoUsuario();
                   } catch (Exception ex) {
            Logger.getLogger(SvNewEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }                
        try {
            controladora.CrearEmpleado(user, cargo, dni, apellido, nombre, direccion, fechaNac);
        } catch (Exception ex) {
            Logger.getLogger(SvNewEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession misession = request.getSession(true);
        misession.setAttribute("usuario", usuario);
        misession.setAttribute("password", password);
        response.sendRedirect ("reserva.jsp");
        
            
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
