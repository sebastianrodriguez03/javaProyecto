/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Usuario
 */
public class DetallePedido {
   private int IdDetallePedido;
   private int IdPlato;
   private int IdPedido;
   private double Precio;
   private int Cantidad;

    public int getIdDetallePedido() {
        return IdDetallePedido;
    }

    public void setIdDetallePedido(int IdDetallePedido) {
        this.IdDetallePedido = IdDetallePedido;
    }

    public int getIdPlato() {
        return IdPlato;
    }

    public void setIdPlato(int IdPlato) {
        this.IdPlato = IdPlato;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int IdPedido) {
        this.IdPedido = IdPedido;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}
