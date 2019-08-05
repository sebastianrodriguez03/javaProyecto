/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.PagoDL;
import Model.Pago;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PagoBL {
            PagoDL pagodl = new PagoDL();

    public List listar() {
        return pagodl.listar();
    }

    public void insertar(Pago pa) {
        pagodl.insertar(pa);
    }

    public List buscar(int IdPago) {
        return pagodl.buscar(IdPago);
    }

    public void actualizar(Pago pa) {
        pagodl.actualizar(pa);
    }

    public void eliminar(int IdPago) {
        pagodl.eliminar(IdPago);
    }
}
