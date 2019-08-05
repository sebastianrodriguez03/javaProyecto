/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MesaDL;
import Model.Mesa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MesaBL {
    MesaDL mesadl = new MesaDL();

   public List listar() {
        return mesadl.listar();
    }

    public void insertar(Mesa m) {
        mesadl.insertar(m);
    }

    public List buscar(int IdMesa) {
        return mesadl.buscar(IdMesa);
    }

    public void actualizar(Mesa m) {
        mesadl.actualizar(m);
    }

    public void eliminar(int IdMesa) {
        mesadl.eliminar(IdMesa);
    }

}
