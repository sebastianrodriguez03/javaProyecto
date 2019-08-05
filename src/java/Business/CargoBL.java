/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CargoDL;
import Model.Cargo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CargoBL {
        CargoDL cargodl = new CargoDL();

    public List listar() {
        return cargodl.listar();
    }

    public void insertar(Cargo ca) {
        cargodl.insertar(ca);
    }

    public List buscar(int IdCargo) {
        return cargodl.buscar(IdCargo);
    }

    public void actualizar(Cargo ca) {
        cargodl.actualizar(ca);
    }

    public void eliminar(int IdCargo) {
        cargodl.eliminar(IdCargo);
    }
}
