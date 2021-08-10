
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Britos
 */
@Entity
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idReserva;
    @Temporal(TemporalType.DATE)
    Date checkin;
    @Temporal(TemporalType.DATE)
    Date checkout;
    @Temporal(TemporalType.DATE)
    Date fechaReserva;
   @OneToOne
    Huesped huesped;
   @OneToOne
    Habitacion habitacion;
   @OneToOne
   Usuario usuario;
   @Basic
    int personas;
    int dias;
    double montoTotal;

    public Reserva(int idReserva, Date checkin, Date checkout, Date fechaReserva, Huesped huesped, Habitacion habitacion, Usuario usuario, int personas, int dias, double montoTotal) {
        this.idReserva = idReserva;
        this.checkin = checkin;
        this.checkout = checkout;
        this.fechaReserva = fechaReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.usuario = usuario;
        this.personas = personas;
        this.dias = dias;
        this.montoTotal = montoTotal;
    }

  
    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    
            
    
}
