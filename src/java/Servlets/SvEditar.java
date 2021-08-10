package Servlets;

import Logica.Controladora;
import Modelo.Empleado;
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
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //traer datos
         String dniString = request.getParameter("dni");
        int dni =Integer.parseInt(dniString);
        int idUsuario = Integer.parseInt(request.getParameter ("idUsuario"));
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
         Empleado emp = new Empleado ();
        Usuario user = new Usuario();
        emp.setDni(dni);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setFechaNacimiento(fechaNac);
        emp.setDireccion(direccion);
        emp.setCargo(cargo);
        user.setUser(usuario);
        user.setPassword(password);
        user.setIdUsuario(idUsuario);
        try {
            controladora.EditarUsuario(user);
        } catch (Exception ex) {
            Logger.getLogger(SvEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        user = controladora.BuscarUsuario(idUsuario);
        emp.setUsuario(user);
        try {
            controladora.EditarEmpleado(emp);
        } catch (Exception ex) {
            Logger.getLogger(SvEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
                request.getSession().setAttribute("ListaEmpleados", controladora.TraerEmpleados());
                response.sendRedirect("listaEmpleados.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id= Integer.parseInt(request.getParameter("dni")); 
               Controladora control = new Controladora();
               Empleado emp = control.BuscarEmpleado(id);
               HttpSession misession = request.getSession();
               misession.setAttribute("empleado", emp);
               response.sendRedirect("editarEmpleado.jsp");
              
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
