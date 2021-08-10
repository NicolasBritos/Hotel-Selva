/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Reserva;
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
@WebServlet(name = "SvNewReserva", urlPatterns = {"/SvNewReserva"})
public class SvNewReserva extends HttpServlet {


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
     //traer datos Huesped
         String dniString =request.getParameter("dni");
        int dni = Integer.parseInt(dniString);
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter ("nombre");
        String fechaNacString = request.getParameter ("fechaNac");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
       
//traer datos Reserva      
        System.out.println(" ASDDAS HOLA HOLLA");
        String cantPersonasString = request.getParameter("personas");
        int cantPersonas = Integer.parseInt(cantPersonasString);
         System.out.println("personasss:"  + cantPersonas);
        String fechaCheckInString = request.getParameter("checkin");
        String fechaCheckOutString = request.getParameter("checkout");
        int habitacion =Integer.parseInt(request.getParameter("isTitles"));
        System.out.println("habbb:"  + habitacion);
        String fechaActual = request.getParameter("fechaActual");
        System.out.println("FECHA ACTUAL:" + fechaActual);
        Date fechaNac = new Date();
        Date fechaCheckIn = new Date ();
        Date fechaCheckOut = new Date();
        Date fechaAct = new Date();
        try {  
           fechaAct = new SimpleDateFormat("yyyy-MM-dd").parse(fechaActual);
           fechaNac=new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacString);
           System.out.println( "Fecha Nac: " + fechaNac);
            fechaCheckIn= new SimpleDateFormat("yyyy-MM-dd").parse(fechaCheckInString);
            System.out.println("Fecha In:" + fechaCheckIn);
           fechaCheckOut= new SimpleDateFormat("yyyy-MM-dd").parse(fechaCheckOutString);
           System.out.println("Fecha out: " + fechaCheckOut);
        } catch (ParseException ex) {
            Logger.getLogger(SvValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
            int dias =  (int) ((fechaCheckOut.getTime() - fechaCheckIn.getTime())/86400000 );
             
            System.out.println ("diass: " + dias);
           Controladora controladora = new Controladora ();
           Habitacion hab = controladora.BuscarHabitacion(habitacion);
           System.out.println(hab.getNro()+" " + hab.getTematica());
           
           //creacion huesped
               Huesped  huesp =  new Huesped();
               huesp.setDni(dni);
               huesp.setApellido(apellido);
               huesp.setNombre(nombre);
               huesp.setFechaNacimiento(fechaNac);
               huesp.setDireccion(direccion);
               huesp.setProfesion(profesion);
               System.out.println("apellido1:" + huesp.getApellido());
               Huesped encontrado = controladora.BuscarHuesped(huesp.getDni());
                        if (encontrado == null){
                         try {
                controladora.CrearHuesped(huesp);
                        System.out.println("apellido3:" + huesp.getApellido());
            } catch (Exception ex) {
                Logger.getLogger(SvNewReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
               }else{
                            huesp = encontrado;
                        }
           double monto = (hab.getPrecio()*dias);
           System.out.println(monto);
           HttpSession misession = request.getSession();
           String usuario = (String) misession.getAttribute("usuario");
           System.out.println("NOMBREUSUARIO: "+ usuario);
            Usuario user = controladora.BuscarUsuarioPNombre(usuario);
            System.out.println("user:" + user.getUser());
            
          //creacion reserva
           Reserva reserv = new Reserva ();
           reserv.setFechaReserva(fechaAct);
           reserv.setCheckin(fechaCheckIn);
           reserv.setCheckout(fechaCheckOut);
           reserv.setDias(dias);
           reserv.setHabitacion(hab);
           reserv.setHuesped(huesp);
           reserv.setMontoTotal(monto);
           reserv.setPersonas(cantPersonas);
           reserv.setUsuario(user);
           
           
           controladora.CrearReserva(reserv);
           
           // cambia estado Ocupado = true de la habitacion reservada.
           hab.setOcupado(true);
        try {
            controladora.EditarHabitacion(hab);
        } catch (Exception ex) {
            Logger.getLogger(SvNewReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
           
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
