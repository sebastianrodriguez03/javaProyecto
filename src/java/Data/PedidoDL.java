/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Pedido;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class PedidoDL {
     
   Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "SELECT c.Nombre as Cliente,m.NumeroPersonas as Npersona, e.Nombre as empleados,c.Direccion,c.Telefono, p.IdPedido, p.IdCliente,p.IdEmpleado,p.IdMesa,p.Fecha,p.Domicilio from cliente c , pedido p,mesa m, empleado e where c.IdCliente = p.IdCliente and p.IdEmpleado= e.IdEmpleado and p.IdMesa= m.IdMesa";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }

    public void insertar(Pedido p) {
        String sql = "insert into pedido (IdCliente,IdEmpleado,IdMesa,Fecha,Domicilio) values(?,?,?,?,?)";
        jdbctemplate.update(sql,p.getIdCliente(), p.getIdEmpleado(), p.getIdMesa(),p.getFecha(),p.getDomicilio());
    }

    public List buscar(int IdPedido) {
        String sql = "select * from pedido where IdPedido=" + IdPedido;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Pedido p) {
        String sql = "update pedido set IdCliente=?,IdEmpleado=?,IdMesa=?,Fecha=?,Domicilio=? where IdPedido=?";
        jdbctemplate.update(sql,p.getIdCliente() , p.getIdEmpleado(), p.getIdMesa(),p.getFecha(),p.getDomicilio(), p.getIdPedido() );
    }
    
   public void eliminar(int IdPedido) {
        String sql = "Delete From pedido where IdPedido=" + IdPedido;
        this.jdbctemplate.update(sql);
    }   
}
