/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Modelo.*;
import Persistencia.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Britos
 */
public class Controladora {
    
   ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
  
      List<Usuario> ListUsuarios = new LinkedList();
      
   
   public boolean ValidarUsuario (String usuario, String password){
       List<Usuario> listaUsuarios = controladoraPersistencia.TraerUsuarios();
        if (listaUsuarios != null){
            for (Usuario user : listaUsuarios){
                if ( user.getUser().equals(usuario) && user.getPassword().equals (password)){
                    return true;
                }
            }
        }
                              return false;
   }
   
   
   // BUSQUEDA
   
   public Empleado BuscarEmpleado (int dni)  {
      
    Empleado emp = controladoraPersistencia.BuscarEmpleado(dni);
      
      return emp;
          } 
   
   public Usuario BuscarUsuario (int id){
       
       Usuario user = controladoraPersistencia.BuscarUsuario(id);
       
       return user;
   }
   
   public Usuario BuscarUsuarioPNombre (String user){
       Usuario encontrado = new Usuario ();
       List <Usuario> usuarios = new LinkedList();
       usuarios = controladoraPersistencia.TraerUsuarios();
       for (Usuario usuario: usuarios){
           if (usuario.getUser().equals(user)){
              encontrado = usuario;
           }
       }
              return encontrado;
   }
   
   public Habitacion BuscarHabitacion(int nro){
       
       Habitacion hab = controladoraPersistencia.BuscarHabitacion(nro);
       
       return hab;
   }
   
   public Huesped BuscarHuesped (int dni){
       
       Huesped huesp = controladoraPersistencia.BuscarHuesped(dni);
  return huesp;
   }
   
   public List <Reserva> BuscarReservasDia(Date fecha){
       List <Reserva> reservasEncontradas = new LinkedList ();
       List <Reserva> reservas = controladoraPersistencia.TraerReservas();
            for (Reserva reserva: reservas){
           if (reserva.getFechaReserva().equals(fecha)){
              reservasEncontradas.add(reserva);
           }
       }
              return reservasEncontradas;
   }
   
   
      public List <Reserva> BuscarReservasEmpleado(int dni){
       Empleado emp = BuscarEmpleado(dni);
       String usuario = emp.getUsuario().getUser();
       List <Reserva> reservasEncontradas = new LinkedList ();
       List <Reserva> reservas = controladoraPersistencia.TraerReservas();
            for (Reserva reserva: reservas){
           if (reserva.getUsuario().getUser() .equals(usuario)){
              reservasEncontradas.add(reserva);
           }
       }
              return reservasEncontradas;
   }
      
      public List <Reserva> BuscarReservasHuespRango(int dni, Date fecha1, Date fecha2){
       List <Reserva> reservasEncontradas = new LinkedList ();
       List <Reserva> reservas = controladoraPersistencia.TraerReservas();
            for (Reserva reserva: reservas){
           if (reserva.getHuesped().getDni()== dni && (reserva.getFechaReserva().after(fecha1) && reserva.getFechaReserva().before(fecha2) ) ){
              reservasEncontradas.add(reserva);
           }
       }
          return reservasEncontradas;
          
          
      }
   
   
   public List<Empleado> TraerEmpleados (){
       
       return controladoraPersistencia.TraerEmpleados();
   }
   
   public List <Usuario> TraerUsuarios(){
       
       return controladoraPersistencia.TraerUsuarios();       
   }
   
   public List <Habitacion> TraerHabitaciones(){
       
       return controladoraPersistencia.TraerHabitaciones();
       
   }
   
   public List <Habitacion> TraerHabitacionesDisponibles(){
       
       List <Habitacion> listaCompleta = controladoraPersistencia.TraerHabitaciones();
       List <Habitacion> listaDisponible = new LinkedList ();
       for ( Habitacion hab: listaCompleta) {
           if (hab.isOcupado()==false){
               listaDisponible.add(hab);
           }
                  }     
       return listaDisponible;
   }
   
   public List <Reserva> TraerReservas(){
       
       return controladoraPersistencia.TraerReservas();
       
       
   }
   
   
   
   public List <Huesped> TraerHuespedes(){
       
       return controladoraPersistencia.TraerHuespedes();
       
   }
   
   
   // CREACION
   public void CrearUsuario (String user, String pass){
       Usuario usuar = new Usuario ();
       usuar.setUser(user);
       usuar.setPassword(pass);
       
       controladoraPersistencia.CrearUsuario(usuar);
       
   }
   
   public void CrearHuesped (Huesped  huesp) throws Exception{
       
       controladoraPersistencia.CrearHuesped(huesp);
       
   }
   
      public void CrearEmpleado(Usuario user, String cargo, int dni, String apellido, String nombre, String direccion, Date fechaNac) throws Exception{
             
       Empleado emp = new Empleado();
       emp.setCargo(cargo);
       emp.setUsuario(user);
       emp.setDni(dni);
       emp.setApellido(apellido);
       emp.setNombre(nombre);
       emp.setDireccion(direccion);
       emp.setFechaNacimiento(fechaNac);
      
       controladoraPersistencia.CrearEmpleado(emp);
       
   }
   
      public void CrearHabitacion (Habitacion hab){
          
          controladoraPersistencia.CrearHabitacion(hab);
          
      }
      
      
      public void CrearReserva (Reserva reserv){
          
          controladoraPersistencia.CrearReserva(reserv);
          
      }
         
      //////////////// Obtener Ultimos cargados
      
      public Usuario UltimoUsuario () throws Exception{
    ListUsuarios = TraerUsuarios();
    Usuario usuario= new Usuario ();
     for(Usuario unUsuario:ListUsuarios){
              usuario = unUsuario;
     }
    return usuario;
}
      
      
      
      ///////////Eliminar
      
      public void BorrarEmpleado (int id, int idUsuario) throws NonexistentEntityException{
          
          controladoraPersistencia.BorrarEmpleado(id, idUsuario);
          
      }
      
   public void BorrarReserva (int id) throws NonexistentEntityException{
       
       controladoraPersistencia.BorrarReserva(id);
       
   }
      
      
      
      //////Editar
      
      
      public void EditarEmpleado (Empleado emp) throws Exception{
          
        controladoraPersistencia.EditarEmpleado(emp);
          
          
    }
      
      public void EditarUsuario (Usuario user) throws Exception{
          
          controladoraPersistencia.EditarUsuario(user);
          
      }
      
      public void EditarHabitacion (Habitacion hab) throws Exception{
          
          controladoraPersistencia.EditarHabitacion(hab);
          
      }
      
      
      public void EditarHuesped (Huesped huesp, int dniViejo) throws Exception{
          
          controladoraPersistencia.EditarHuesped(huesp);
             List <Reserva> reservas = controladoraPersistencia.TraerReservas();
            for (Reserva reserva: reservas){
           if ( reserva.getHuesped().getDni() ==  dniViejo   ){
             Reserva encontrado = reserva;
             encontrado.setHuesped(huesp);
             controladoraPersistencia.EditarReserva(encontrado);
           }
            if (huesp.getDni() != dniViejo){
           controladoraPersistencia.BorrarHuesped(dniViejo);
       }
       }
          
          
      }
      
}
