/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Britos
 */
public class ControladoraPersistencia {
    
     EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    HuespedJpaController huespedJpa = new HuespedJpaController();
     PersonaJpaController personaJpa = new PersonaJpaController();
     ReservaJpaController reservaJpa = new ReservaJpaController();
     UsuarioJpaController usuarioJpa = new UsuarioJpaController();
     HabitacionJpaController habitacionJpa = new HabitacionJpaController();
    
     //CREAR
     public void CrearUsuario (Usuario user){
         usuarioJpa.create(user);
              }
             
     public void CrearEmpleado(Empleado empleado) throws Exception{
         empleadoJpa.create(empleado);
     }
     
     public void CrearHabitacion (Habitacion hab){
         
         habitacionJpa.create(hab);
         
              }

     
      public void CrearHuesped (Huesped  huesp) throws Exception{
       
    huespedJpa.create(huesp);
       
   }
     
       public void CrearReserva (Reserva reserv){
          
         reservaJpa.create(reserv);
          
      }
      
      
    //BUSCAR 
  public Empleado BuscarEmpleado (int dni){
      
    return empleadoJpa.findEmpleado(dni);
      
  } 
     
  public Usuario BuscarUsuario (int id){
          
      return usuarioJpa.findUsuario(id);
  }
  
  public Habitacion BuscarHabitacion (int nro){
      
      return habitacionJpa.findHabitacion(nro);
      
  }
  
  public Huesped BuscarHuesped (int dni){
       
         return huespedJpa.findHuesped(dni);
   }
  
  public List<Usuario> TraerUsuarios (){
           
      return usuarioJpa.findUsuarioEntities();
                      }
  
  public List <Habitacion> TraerHabitaciones(){
      
      return habitacionJpa.findHabitacionEntities();
      
  }
  
    public List <Huesped> TraerHuespedes(){
      
      return huespedJpa.findHuespedEntities();
      
  }
  

  public List<Empleado> TraerEmpleados (){
           return empleadoJpa.findEmpleadoEntities();
}
                        
  
        public List <Reserva> TraerReservas(){
       
       return reservaJpa.findReservaEntities();
       
       
   }
  
  //BORRAR
  
    public void BorrarEmpleado (int id, int idUsuario) throws NonexistentEntityException{
      
      empleadoJpa.destroy(id);      
      usuarioJpa.destroy(idUsuario);
  }
  
     public void BorrarReserva (int id) throws NonexistentEntityException{
       
     reservaJpa.destroy(id);
       
   }
     
    public void BorrarHuesped (int dni) throws NonexistentEntityException{
        
        huespedJpa.destroy(dni);
        
    } 
    
  
  
  //EDITAR
    
    public void EditarEmpleado (Empleado emp) throws Exception{
        
        empleadoJpa.edit(emp);
        
    }
    
    public void EditarUsuario (Usuario user) throws Exception{
        
        usuarioJpa.edit(user);
                
        
    }
    
    
       public void EditarHabitacion (Habitacion hab) throws Exception{
          
          habitacionJpa.edit(hab);
          
      }
       
        public void EditarHuesped (Huesped huesp) throws Exception{
          
          huespedJpa.edit(huesp);
          
      }
        
        public void EditarReserva (Reserva reserv) throws Exception{
            
            reservaJpa.edit(reserv);
            
        }
      
  
  
  
}