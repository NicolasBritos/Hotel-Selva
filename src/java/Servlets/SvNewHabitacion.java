package Servlets;

import Logica.Controladora;
import Modelo.Habitacion;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvNewHabitacion", urlPatterns = {"/SvNewHabitacion"})
public class SvNewHabitacion extends HttpServlet {

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
        int piso = Integer.parseInt(request.getParameter("piso"));
        double precio =Double.parseDouble(request.getParameter("precio"));
        String tematica = request.getParameter("tematica");
        String tipo = request.getParameter ("tipo");
        boolean ocupado = false;
        Controladora controladora = new Controladora ();
        Habitacion hab = new Habitacion();
        hab.setOcupado(ocupado);
        hab.setPiso(piso);
        hab.setPrecio(precio);
        hab.setTematica(tematica);
        hab.setTipo(tipo);
        controladora.CrearHabitacion(hab);
        response.sendRedirect ("crearHabitacion.jsp");
                                            }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
