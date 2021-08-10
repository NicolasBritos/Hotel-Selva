<%@page import="Modelo.Huesped"%>
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
                    <link href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap" rel="stylesheet">
         <link rel="stylesheet" href="css/style-listaEmpl.css">
        <title>Lista de huespedes</title>
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
	<table class="table-list">
            <caption class="title-form">Huespedes</caption>
		<thead>
			<tr>
				<th class='nom-column'>Dni</th>
				<th class='nom-column'>Apellido</th>
				<th class='nom-column'>Nombre</th>
                                                                                <th class='nom-column'>Profesion</th>
                                                                                <th class='nom-column'></th>
				</tr>
		</thead>
		<tbody>
                    <% Controladora control = new Controladora();
                    List <Huesped> listaHuespedes = control.TraerHuespedes();
                    for (Huesped hues : listaHuespedes){
                        %>
                    			<tr>
                                                                  <% int dni = hues.getDni();
                                                                    String apellido = hues.getApellido();
                                                                    String nombre = hues.getNombre();
                                                                     String profesion = hues.getProfesion();
                                                                                                                                         %>
				<td><%=dni%></td>
				<td><%=apellido%> </td>
				<td><%=nombre%></td>
                                                                                 <td><%=profesion%></td>
                                                                                    
                                <td>                
                                    <form name="editar" action="SvEditarHuesped" method="POST" style="display:inline" >  
                                        <input type="hidden" name ="dni" value="<%=dni %>">
                                         <button type="submit" class="btn-editar" data-title="Edit" style="display:inline">Editar</button>
                                                                                                     </form>
                                                                </td>
                                                               
                                       			</tr>
			
		</tbody>
                <% } %>
	</table>
</div>
    </body>
</html>
