package Modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Britos
 */
@Entity
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int nro;
    @Basic
    int piso;
    String tematica;
    String tipo;
    double precio;
    boolean ocupado;

      public Habitacion(int nro, int piso, String tematica, String tipo, double precio, boolean ocupado) {
        this.nro = nro;
        this.piso = piso;
        this.tematica = tematica;
        this.tipo = tipo;
        this.precio = precio;
        this.ocupado = ocupado;
    }

    public Habitacion (){
            }
    
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Habitacion: " + nro + ", piso: " + piso + ", tematica: " + tematica + ", tipo: " + tipo + ", precio: " + precio;
    }

  
    
    
    
}
