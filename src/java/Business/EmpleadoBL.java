/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.EmpleadoDL;
import Model.Empleado;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmpleadoBL {
     EmpleadoDL empleadodl = new EmpleadoDL();

    public List listar() {
        return empleadodl.listar();
    }

    public void insertar(Empleado e) {
        empleadodl.insertar(e);
    }

    public List buscar(int IdPedido) {
        return empleadodl.buscar(IdPedido);
    }

    public void actualizar(Empleado e) {
        empleadodl.actualizar(e);
    }

    public void eliminar(int IdEmpleado) {
        empleadodl.eliminar(IdEmpleado);
    }

}
