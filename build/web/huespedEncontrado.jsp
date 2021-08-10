<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.Huesped"%>
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
         <title>Huesped encontrado</title>
    </head>
        <body>
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
         <form action="" method="GET">
             <% HttpSession misession = request.getSession();
                    Huesped huesp = (Huesped) misession.getAttribute("huesped");
             %>
            <div class="div-register-emp">
        <h3 class="title-form" >Datos del Huesped </h3>
        <label>Dni</label>
      <input class="controls"  type="number" placeholder="Ingresa dni..." required name="dni" required value="<%=huesp.getDni()%>" readonly="readonly"> 
      <br />
        <label>Apellido</label>
      <input class="controls" type="text" placeholder="Ingresa apellido..." required name="apellido" required value="<%=huesp.getApellido()%>" readonly="readonly"> 
      <br />
        <label>Nombre</label>
      <input class="controls" type="text" placeholder="Ingresa nombre..." required name="nombre" required value="<%=huesp.getNombre()%>" readonly="readonly"> 
      <br />
        <label>Fecha de nacimiento</label>
          <% String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(huesp.getFechaNacimiento());
                         %>
        <input class="controls" type="date" required name="fechaNac"required value="<%=date%>" readonly="readonly"> 
                  <br/>
      <label>Direccion</label>
      <input class="controls" type="text" placeholder="Ingresa direccion..." required name="direccion"required value="<%=huesp.getDireccion()%>" readonly="readonly"> 
         <br />
      <label> Profesion </label>
       <input class="controls " type="text" name="cargo" value="<%=huesp.getProfesion()%>"  readonly="readonly" >
         <br />
                          </div>
                               </form>
           </div>
            </body>
</html>
