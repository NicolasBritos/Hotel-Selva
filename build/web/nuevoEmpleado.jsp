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
        <title>Crear Empleado</title>
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
         <form action="SvNewEmpleado" method="POST">
         <div class="div-register-emp">
        <h3 class="title-form" >Datos del Empleado </h3>
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
      <input class="controls" type="date" required name="fechaNac"required> 
      <br/>
      <label>Direccion</label>
      <input class="controls" type="text" placeholder="Ingresa direccion..." required name="direccion"required> 
         <br />
      <label> Cargo </label>
       <select class="controls " name="cargo">
       <option >Recepcionista</option>
      <option >Administrador</option>
       </select>
       <br />
      <label>Usuario</label>
      <input class="controls" type="text"placeholder="Ingresa usuario..." required name="usuario"required>
      <label>Contraseña</label>
      <input class="controls" type="text"placeholder="Ingresa contraseña..." required name="password"required>
                    </div>
                                       <div class="div-button-EmpNew">
            <button type="submit" class="button-EmpNew" ><b>Crear empleado</b> </button>
           </div>
</form>
              </div>
            </body>
</html>
