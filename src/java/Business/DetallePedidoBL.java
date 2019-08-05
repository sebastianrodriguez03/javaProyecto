/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.DetallePedidoDL;
import Model.DetallePedido;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DetallePedidoBL {
     DetallePedidoDL detallepedidobl = new DetallePedidoDL();

    public List listar() {
        return detallepedidobl.listar();
    }

    public void insertar(DetallePedido dp) {
        detallepedidobl.insertar(dp);
    }

    public List buscar(int IdDetallePedido) {
        return detallepedidobl.buscar(IdDetallePedido);
    }

    public void actualizar(DetallePedido dp) {
        detallepedidobl.actualizar(dp);
    }

    public void eliminar(int IdCliente) {
        detallepedidobl.eliminar(IdCliente);
    }
}
