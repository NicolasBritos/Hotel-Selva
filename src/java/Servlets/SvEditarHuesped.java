/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Modelo.Empleado;
import Modelo.Huesped;
import Modelo.Usuario;
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
@WebServlet(name = "SvEditarHuesped", urlPatterns = {"/SvEditarHuesped"})
public class SvEditarHuesped extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  //traer datos
        String dniViejoString = (String) request.getParameter ("dniViejo");
         int dniViejo = Integer.parseInt(dniViejoString);
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
        String profesion = request.getParameter("profesion");
        
        Controladora controladora = new Controladora ();
         Huesped huesp = new Huesped ();
        huesp.setDni(dni);
        huesp.setNombre(nombre);
        huesp.setApellido(apellido);
        huesp.setFechaNacimiento(fechaNac);
        huesp.setDireccion(direccion);
        huesp.setProfesion(profesion);
               try {
            controladora.EditarHuesped(huesp, dniViejo);
        } catch (Exception ex) {
            Logger.getLogger(SvEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
                request.getSession().setAttribute("ListaHuespedes", controladora.TraerHuespedes());
                response.sendRedirect("listaHuespedes.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              int id= Integer.parseInt(request.getParameter("dni")); 
               Controladora control = new Controladora();
               Huesped huesp = control.BuscarHuesped(id);
               HttpSession misession = request.getSession();
               misession.setAttribute("dniViejo", id);
               misession.setAttribute("huesped", huesp);
               response.sendRedirect("editarHuesped.jsp");
        
        
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
