<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                   <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,600;1,400&display=swap" rel="stylesheet">
                    <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap" rel="stylesheet">
               <link rel="stylesheet" href="css/style-reserva.css">
        <title>Inicio</title>
        <link rel="icon" type="image/png" href="images/icon.png" />
      </head>
                          <body class="img js-fullheight" style="background-image: url(images/reserv.jpg);">
          <div id="container">
     <nav>   
        <ul>
            <li class ="ul-main"><a href="reserva.jsp">Inicio</a></li>
            <li class="ul-main"><a href="#">Reservas<i class="down"></i></a>
               <ul>
                 <li class="ul-sub"><a href="#">Buscar<i class="down"></i></a>
                     <ul>
                <li class="ul-sub" ><a href="buscarReservaPorDia.jsp">Por fecha</a></li>
                  <li class="ul-sub"><a href="buscarReservaPorEmpleado.jsp">Por empleado</a></li>
                     <li class="ul-sub"><a href="buscarReservaPorHuespRango.jsp">Huesped/Rango</a></li>
                     </ul>
                <li class="ul-sub"><a href="listaReservas.jsp">Listar</a></li>
                <li><a href="#"></a></li>
            </ul>        
            </li>
            <li class="ul-main"><a href="#">Empleado<i class="down"></i></a>
               <ul>
                <li class="ul-sub"><a href="buscarEmpleado.jsp">Buscar</a></li>
                <li class="ul-sub"><a href="nuevoEmpleado.jsp">Crear</a></li>
                <li class="ul-sub"><a href="listaEmpleados.jsp">Listar</a></li>
                                              </ul>
                </li>
                <li class="ul-main"><a href="#">Habitaciones<i class="down"></i></a>
                       <ul>
                <li class="ul-sub"><a href="crearHabitacion.jsp">Crear</a></li>
                <li class="ul-sub" ><a href="listaHabitaciones.jsp">Listar</a></li>
                <li><a href="#"></a></li>
            </ul>        
            </li>
             <li class="ul-main"><a href="#">Huespedes<i class="down"></i></a>
                  <ul>
                <li class="ul-sub"><a href="buscarHuesped.jsp">Buscar</a></li>
                <li class="ul-sub" ><a href="listaHuespedes.jsp">Listar</a></li>
                <li><a href="#"></a></li>
            </ul>        
           <li class ="ul-main"><a href="index.jsp">Cerrar Sesión</a></li>
            </ul>
                        </nav>
</div>                                                                                                
                                                               <div class="div-main">
                       <form action="SvNewReserva" method="POST">
                           <% HttpSession misession = request.getSession();
                    String user = (String) misession.getAttribute("usuario");
                    misession.setAttribute("usuario1", user);
                   Date fecha = new Date();
                   String pattern = "yyyy-MM-dd";
                   SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                   String fechaActual = simpleDateFormat.format(fecha);
                               
                                %>
              <input type='hidden' required name="fechaActual" value='<%=fechaActual%>'>
             <input type='hidden' required name="nombreUsuario" value='<%=user%>'>
                                                            <div class="div-register">
                                                          <h3 class="title-form" >Datos del Huesped </h3>
        <label>Dni</label>
      <input class="controls"  type="number" placeholder="Ingresa dni..." required name="dni" required> 
      <br />
        <label>Apellido</label>
      <input class="controls" type="text" placeholder="Ingresa apellido..." required name="apellido" required> 
      <br />
        <label>Nombre</label>
      <input class="controls" type="text" placeholder="Ingresa nombre..." required name="nombre" required> 
      <br />
        <label>Fecha de nacimiento</label>
      <input class="controls" type="date" required name="fechaNac" required> 
      <br/>
      <label>Direccion</label>
      <input class="controls" type="text" placeholder="Ingresa direccion..." required name="direccion" required> 
      <br />
      <label>Profesion</label>
      <input class="controls" type="text"placeholder="Ingresa profesion..." required name="profesion" required>
               </div>
                 <div class="div-register">
         <h3 class="title-form">Datos de la Reserva</h3>
        <label>Cantidad de personas</label>
        <input class="controls"  type="number" placeholder="Ingresa cantidad de personas...." required name="personas" required> 
                 <br />
      <label>Check-In</label>
      <input class="controls" type="date" required name="checkin" required> 
      <br/>
      <label>Check-Out</label>
      <input class="controls" type="date" required name="checkout" required> 
      <br />
          <label>Habitacion</label>
          <%          
              Controladora control = new Controladora();
             List <Habitacion> listHabitaciones  = control.TraerHabitacionesDisponibles();
           
                    %>
       <select id="isTitles" class="controls " name  ="isTitles" required>
         <% 
             for (Habitacion hab : listHabitaciones ){ 
               %>
                       <option value="<%=hab.getNro()%>"><%=hab.toString()%></option>
           <%  }  %>
             </select>                                                                   
                                     <br />
       <label>Cantidad de días</label>
             <input class="controls" type="number" disabled="disabled" readonly="readonly"  > 
      <label>Monto total</label>
      <input class="controls" type="number" disabled="disabled" readonly="readonly" >
                                          </div>
                                        <div class="div-button">
                                         <button type="submit" class="button" ><b>Crear reserva</b> </button>
           </div>
              </form>
                                                                        </div>
                      </body>

</html>
