package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reserva_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("                <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap\" rel=\"stylesheet\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\t<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("                    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("                   <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,600;1,400&display=swap\" rel=\"stylesheet\">\n");
      out.write("                    <link href=\"https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap\" rel=\"stylesheet\">\n");
      out.write("               <link rel=\"stylesheet\" href=\"css/style-reserva.css\">\n");
      out.write("        <title>Inicio</title>\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icon.png\" />\n");
      out.write("      </head>\n");
      out.write("                          <body class=\"img js-fullheight\" style=\"background-image: url(images/reserv.jpg);\">\n");
      out.write("          <div id=\"container\">\n");
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
      out.write("                <li class=\"ul-sub\"><a href=\"buscarEmpleado.jsp\">Buscar</a></li>\n");
      out.write("                <li class=\"ul-sub\"><a href=\"nuevoEmpleado.jsp\">Crear</a></li>\n");
      out.write("                <li class=\"ul-sub\"><a href=\"listaEmpleados.jsp\">Listar</a></li>\n");
      out.write("                                              </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("                        </nav>\n");
      out.write("</div>                                                                                                \n");
      out.write("                                                               <div class=\"div-main\">\n");
      out.write("                       <form action=\"\">\n");
      out.write("         <div class=\"div-register\">\n");
      out.write("        <h3 class=\"title-form\" >Datos del Huesped </h3>\n");
      out.write("        <label>Dni</label>\n");
      out.write("      <input class=\"controls\"  type=\"number\" placeholder=\"Ingresa dni...\"> \n");
      out.write("      <br />\n");
      out.write("        <label>Apellido</label>\n");
      out.write("      <input class=\"controls\" type=\"text\" placeholder=\"Ingresa apellido...\"> \n");
      out.write("      <br />\n");
      out.write("        <label>Nombre</label>\n");
      out.write("      <input class=\"controls\" type=\"text\" placeholder=\"Ingresa nombre...\"> \n");
      out.write("      <br />\n");
      out.write("        <label>Fecha de nacimiento</label>\n");
      out.write("      <input class=\"controls\" type=\"date\"> \n");
      out.write("      <br/>\n");
      out.write("      <label>Direccion</label>\n");
      out.write("      <input class=\"controls\" type=\"text\" placeholder=\"Ingresa direccion...\"> \n");
      out.write("      <br />\n");
      out.write("      <label>Profesion</label>\n");
      out.write("      <input class=\"controls\" type=\"text\"placeholder=\"Ingresa profesion...\">\n");
      out.write("               </div>\n");
      out.write("                 <div class=\"div-register\">\n");
      out.write("         <h3 class=\"title-form\">Datos de la Reserva</h3>\n");
      out.write("        <label>Cantidad de personas</label>\n");
      out.write("      <input class=\"controls\" type=\"number\" placeholder=\"Ingresa cantidad de personas...\"> \n");
      out.write("      <br />\n");
      out.write("      <label>Check-In</label>\n");
      out.write("      <input class=\"controls\" type=\"date\"> \n");
      out.write("      <br/>\n");
      out.write("      <label>Check-Out</label>\n");
      out.write("      <input class=\"controls\" type=\"date\"> \n");
      out.write("      <br />\n");
      out.write("      <label> Habitacion </label>\n");
      out.write("       <select class=\"controls\">\n");
      out.write("      <option value=\"1\">Tipo 1</option>\n");
      out.write("      <option value=\"2\">Tipo 2</option>\n");
      out.write("      <option  value=\"3\">Tipo 3</option>\n");
      out.write("      </select>\n");
      out.write("       <br />\n");
      out.write("       <label>Cantidad de días</label>\n");
      out.write("      <input class=\"controls\" type=\"number\" disabled=\"disabled\" readonly=\"readonly\" > \n");
      out.write("      <br />\n");
      out.write("      <label>Monto total</label>\n");
      out.write("      <input class=\"controls\" type=\"number\" disabled=\"disabled\" readonly=\"readonly\" >\n");
      out.write("                                          </div>\n");
      out.write("    </form>\n");
      out.write("                                     <div class=\"div-button\">\n");
      out.write("                                         <button type=\"submit\" class=\"button\" ><b>Crear reserva</b> </button>\n");
      out.write("           </div>\n");
      out.write("                                                                        </div>\n");
      out.write("                      </body>\n");
      out.write("\n");
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
