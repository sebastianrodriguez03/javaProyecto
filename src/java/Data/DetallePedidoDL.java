/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.DetallePedido;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class DetallePedidoDL {
     Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "SELECT dp.IdDetallePedido,dp.Cantidad,dp.Precio,pl.NombrePlato as Plato,p.IdPedido as Pedido\n" +
                     "from detallepedido dp, plato pl, Pedido p\n" +
                     "where dp.IdPlato=pl.IdPlato and dp.IdPedido= p.IdPedido;";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }

    public void insertar(DetallePedido dp) {
        String sql = "insert into DetallePedido (IdPlato,IdPedido,Precio,Cantidad) values(?,?,?,?)";
        jdbctemplate.update(sql,dp.getIdPlato(),dp.getIdPedido(),dp.getPrecio(),dp.getCantidad());
    }

    public List buscar(int IdDetallePedido) {
        String sql = "select * from detallepedido where IdDetallePedido=" + IdDetallePedido;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(DetallePedido dp) {
        String sql = "update detallepedido set IdPlato=?,IdPedido=?,Precio=?,Cantidad=? where IdDetallePedido=?";
        jdbctemplate.update(sql,dp.getIdPlato(),dp.getIdPedido(),dp.getPrecio(),dp.getCantidad(),dp.getIdDetallePedido());
    }
    
   public void eliminar(int IdDetallePedido) {
        String sql = "Delete From detallepedido where IdDetallePedido=" + IdDetallePedido;
        this.jdbctemplate.update(sql);
    }   
}
