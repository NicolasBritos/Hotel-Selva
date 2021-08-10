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
@WebServlet(name = "SvBuscarReservaPorDia", urlPatterns = {"/SvBuscarReservaPorDia"})
public class SvBuscarReservaPorDia extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
          String fechaString = request.getParameter("fechaReserva");
        Date fechaReserv = new Date();
        try {
            fechaReserv = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(SvBuscarReservaPorDia.class.getName()).log(Level.SEVERE, null, ex);
        }
        Controladora control = new Controladora();
       List <Reserva> listaReservas = control.BuscarReservasDia(fechaReserv);
       request.getSession().setAttribute("fecha", fechaReserv);
        request.getSession().setAttribute("listaReservas", listaReservas);
                response.sendRedirect("reservasPorDia.jsp");
        
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
