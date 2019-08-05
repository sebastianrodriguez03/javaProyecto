/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data.ClienteDL;
import Model.Cliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteBL {
    ClienteDL clientedl = new ClienteDL();

    public List listar() {
        return clientedl.listar();
    }

    public void insertar(Cliente c) {
        clientedl.insertar(c);
    }

    public List buscar(int IdCliente) {
        return clientedl.buscar(IdCliente);
    }

    public void actualizar(Cliente c) {
        clientedl.actualizar(c);
    }

    public void eliminar(int IdCliente) {
        clientedl.eliminar(IdCliente);
    }
}
