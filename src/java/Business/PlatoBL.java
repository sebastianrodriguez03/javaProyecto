/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.PlatoDL;
import Model.Plato;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PlatoBL {
      PlatoDL platodl = new PlatoDL();

    public List listar() {
        return platodl.listar();
    }

    public void insertar(Plato pl) {
        platodl.insertar(pl);
    }

    public List buscar(int IdPlato) {
        return platodl.buscar(IdPlato);
    }

    public void actualizar(Plato pl) {
        platodl.actualizar(pl);
    }

    public void eliminar(int IdPlato) {
        platodl.eliminar(IdPlato);
    }
}
