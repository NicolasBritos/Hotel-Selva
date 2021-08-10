
package Servlets;

import Logica.Controladora;
import Modelo.Huesped;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Britos
 */
@WebServlet(name = "SvBuscarHuesped", urlPatterns = {"/SvBuscarHuesped"})
public class SvBuscarHuesped extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
           String dniString = request.getParameter("dni");
        int dni = Integer.parseInt(dniString);
        Controladora control = new Controladora();
        Huesped huesp = control.BuscarHuesped(dni);
        request.getSession().setAttribute("huesped", huesp);
         response.sendRedirect("huespedEncontrado.jsp");
        
        
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
