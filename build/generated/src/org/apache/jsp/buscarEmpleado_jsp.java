package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import Modelo.Empleado;

public final class buscarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\t<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("                    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("                   <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,600;1,400&display=swap\" rel=\"stylesheet\">\n");
      out.write("                    <link href=\"https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap\" rel=\"stylesheet\">\n");
      out.write("               <link rel=\"stylesheet\" href=\"css/style-reserva.css\">\n");
      out.write("         <title>Editar Empleado</title>\n");
      out.write("    </head>\n");
      out.write("        <body>\n");
      out.write("        <body class=\"img js-fullheight\" style=\"background-image: url(images/reserv.jpg);\">\n");
      out.write("             <div id=\"container-nav\">\n");
      out.write("     <nav>   \n");
      out.write("        <ul>\n");
      out.write("            <li class =\"ul-main\"><a href=\"reserva.jsp\">Inicio</a></li>\n");
      out.write("            <li class=\"ul-main\"><a href=\"#\">Reservas<i class=\"down\"></i></a>\n");
      out.write("            <!-- Primer Menu Desplegable -->\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"ul-sub\" ><a href=\"#\">Buscar</a></li>\n");
      out.write("                <li><a href=\"#\"></a></li>\n");
      out.write("                <li><a href=\"#\"></a></li>\n");
      out.write("            </ul>        \n");
      out.write("            </li>\n");
      out.write("            <li class=\"ul-main\"><a href=\"#\">Empleado<i class=\"down\"></i></a>\n");
      out.write("             <!-- Primer Menu Desplegable -->\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"ul-sub\"><a href=\"#\">Buscar</a></li>\n");
      out.write("                <li class=\"ul-sub\"><a href=\"nuevoEmpleado.jsp\">Crear</a></li>\n");
      out.write("                <li class=\"ul-sub\"><a href=\"listaEmpleados.jsp\">Listar</a></li>\n");
      out.write("                                              </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("                        </nav>\n");
      out.write("          <div class=\"div-main\">\n");
      out.write("         <form action=\"SvBuscarEmpleado\" method=\"GET\">\n");
      out.write("             <li><a href='SvBuscarEmpleado' class=\"SUBMIT\">Buscar</a></li>\n");
      out.write("         <div class=\"div-register-emp\">\n");
      out.write("        <h3 class=\"title-form\" >Datos del empleado buscado</h3>\n");
      out.write("        <label>Dni</label>\n");
      out.write("      <input class=\"controls\"  type=\"number\" placeholder=\"Ingresa dni...\" required name=\"dni\" required > \n");
      out.write("      <br />\n");
      out.write("        <label>Apellido</label>\n");
      out.write("      <input class=\"controls\" type=\"text\" placeholder=\"Ingresa apellido...\"  disabled=\"disabled\" readonly=\"readonly\">\"> \n");
      out.write("      <br />\n");
      out.write("        <label>Nombre</label>\n");
      out.write("      <input class=\"controls\" type=\"text\"  disabled=\"disabled\" readonly=\"readonly\">\"> \n");
      out.write("      <br />\n");
      out.write("        <label>Fecha de nacimiento</label>\n");
      out.write("          ");
 String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(emp.getFechaNacimiento());
                         
      out.write("\n");
      out.write("        <input class=\"controls\" type=\"date\" required name=\"fechaNac\"required value=\"");
      out.print(date);
      out.write("\"> \n");
      out.write("                  <br/>\n");
      out.write("      <label>Direccion</label>\n");
      out.write("      <input class=\"controls\" type=\"text\" placeholder=\"Ingresa direccion...\" required name=\"direccion\"required value=\"");
      out.print(emp.getDireccion());
      out.write("\"> \n");
      out.write("         <br />\n");
      out.write("      <label> Cargo </label>\n");
      out.write("       <select class=\"controls \" name=\"cargo\" value=\"");
      out.print(emp.getCargo());
      out.write("\">\n");
      out.write("       <option >Recepcionista</option>\n");
      out.write("      <option >Administrador</option>\n");
      out.write("       </select>\n");
      out.write("       <br />\n");
      out.write("      <label>Usuario</label>\n");
      out.write("      <input class=\"controls\" type=\"text\"placeholder=\"Ingresa usuario...\" required name=\"usuario\"required value=\"");
      out.print(emp.getUsuario().getUser());
      out.write("\">\n");
      out.write("      <label>Contraseña</label>\n");
      out.write("      <input class=\"controls\" type=\"text\"placeholder=\"Ingresa contraseña...\" required name=\"password\"required value=\"");
      out.print(emp.getUsuario().getPassword() );
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                                 <div class=\"div-button-EmpNew\">\n");
      out.write("            <button type=\"submit\" class=\"button-EmpNew\"><b>Guardar cambios</b> </button>A\n");
      out.write("           </div>\n");
      out.write("</form>\n");
      out.write("                    </div>\n");
      out.write("            </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
