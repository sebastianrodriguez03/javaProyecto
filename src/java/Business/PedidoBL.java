/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.PedidoDL;
import Model.Pedido;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PedidoBL {
     PedidoDL pedidodl = new PedidoDL();

    public List listar() {
        return pedidodl.listar();
    }

    public void insertar(Pedido p) {
        pedidodl.insertar(p);
    }

    public List buscar(int IdPedido) {
        return pedidodl.buscar(IdPedido);
    }

    public void actualizar(Pedido p) {
        pedidodl.actualizar(p);
    }

    public void eliminar(int IdPedido) {
        pedidodl.eliminar(IdPedido);
    }
    
}
