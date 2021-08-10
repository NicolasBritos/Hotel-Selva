/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Modelo.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "SvBuscarReservaPorHuespRango", urlPatterns = {"/SvBuscarReservaPorHuespRango"})
public class SvBuscarReservaPorHuespRango extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dniS = (String) request.getParameter("dni");
        int dni = Integer.parseInt(dniS);
        String fecha2String = request.getParameter("fecha2");
        String fecha1String = request.getParameter("fecha1");
        Date fecha1 = new Date();
        Date fecha2 = new Date();
        try {
            fecha1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1String);
            fecha2 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2String);
        } catch (ParseException ex) {
            Logger.getLogger(SvBuscarReservaPorDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        Controladora control = new Controladora();
       List <Reserva> listaReservas = control.BuscarReservasHuespRango(dni, fecha1, fecha2);
        request.getSession().setAttribute("listaReservas", listaReservas);
                response.sendRedirect("listaReservasPorHuespRango.jsp");
        
        
        
        
        
    }

  
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
