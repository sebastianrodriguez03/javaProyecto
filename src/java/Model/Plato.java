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
public class Plato {
    
    private int IdPlato;
    private String NombrePlato;
    private String Precio;
    private String Descripcion;

    public int getIdPlato() {
        return IdPlato;
    }

    public void setIdPlato(int IdPlato) {
        this.IdPlato = IdPlato;
    }

    public String getNombrePlato() {
        return NombrePlato;
    }

    public void setNombrePlato(String NombrePlato) {
        this.NombrePlato = NombrePlato;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
