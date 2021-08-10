
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
        <title>Crear Habitacion</title>
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
         <form action="SvNewHabitacion" method="POST">
         <div class="div-find-emp">
        <h3 class="title-form" >Datos de la habitación </h3>
     <label>Tipo</label>
       <select class="controls " required name="tipo" required>
      <option >Single</option>
      <option >Doble</option>
      <option >Triple</option>
      <option >Multiple</option>
       </select>
      <br />
      <label>Temática</label>
       <select class="controls " required name="tematica" required>
       <option>Selva Romantica</option>
      <option >Selva Familiar</option>
      <option >Selva Divertida</option>
       <option >Selva Soledad</option>
       </select>
      <br />
       <label>Precio</label>
      <input class="controls" type="number" placeholder="Ingresa precio..." required name="precio" required> 
      <br />
      <label>Piso</label>
       <select class="controls " name="piso">
      <option >1</option>
      <option >2</option>
      <option >3</option>
      <option >4</option>
       </select>
       <br />
                         </div>
                                       <div class="div-button-EmpNew">
            <button type="submit" class="button-EmpNew" ><b>Crear habitación</b> </button>
           </div>
</form>
              </div>
            </body>
</html>
