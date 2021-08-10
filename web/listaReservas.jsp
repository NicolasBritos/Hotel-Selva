<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.Reserva"%>
<%@page import="Modelo.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="listaEmpleados">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap" rel="stylesheet">
         <link rel="stylesheet" href="css/style-listaEmpl.css">
        <title>Lista de Reservas</title>
    </head>
        <body class="img js-fullheight" style="background-image: url(images/iguazu.jpg);">
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
  <div class="container">
	<table>
            <caption class="title-form">Reservas</caption>
		<thead>
			<tr>
				<th class='nom-column'>idReserva</th>
				<th class='nom-column'>Huesped</th>
				<th class='nom-column'>Apellido</th>
                                                                                <th class='nom-column'>Personas</th>
                                                                                 <th class='nom-column'>Habitacion</th>
                                                                                <th class='nom-column'>Check in</th>
                                                                                <th class='nom-column' >Check out</th>
                                                                                <th class='nom-column'> </th>
                                                                               
				</tr>
		</thead>
		<tbody>
                    <% Controladora control = new Controladora();
                    List <Reserva> listaReservas = control.TraerReservas();
                    for (Reserva reserv : listaReservas){
                        %>
                    			<tr>
                                                             <% String apellido = reserv.getHuesped().getApellido();
                                                                     int dni = reserv.getHuesped().getDni();
                                                                     int idReserva =reserv.getIdReserva();
                                                                    int personas = reserv.getPersonas();
                                                                    int  nroHabitacion = reserv.getHabitacion().getNro();
                                                                      String pattern = "dd-MM-yyyy";
                                                                     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                                                     String checkIn = simpleDateFormat.format(reserv.getCheckin());
                                                                     String checkOut =simpleDateFormat.format( reserv.getCheckout());
                                                                      
                                                             %>
				<td><%=idReserva%></td>
				<td><%=dni%> </td>
				<td><%=apellido%></td>
                                                                                <td><%=personas%></td>
                                                                                 <td><%=nroHabitacion%></td>
                                                                                 <td WIDTH="500" class="fecha-formato"><%=checkIn%></td>
                                                                                 <td WIDTH="500" class="fecha-formato"><%=checkOut%></td>
                                                                                 
                                                                                                
                                                                 <td>                
                                    <form name="borrar" action="SvBorrarReserva" method="POST" style="display:inline" >  
                                        <input type="hidden" required name ="habitacion" value="<%=nroHabitacion%>">
                                        <input type="hidden" required name ="idReserva" value="<%=idReserva%>">
                                        
                                        <button type="submit" class="btn-borrar" data-title="Delete" style="display:inline">Borrar</button>
                                                                                                     </form>
                                                                </td>
			</tr>
			
		</tbody>
                <% } %>
	</table>
</div>
    </body>
</html>
