/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Pago;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class PagoDL {
    Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
       String sql = "SELECT pa.IdPago,pa.FechaInicio,pa.Valor,pa.Descripcion,pa.FechaFin,e.Nombre as Empleado \n" +
                     "from pago pa , empleado e\n" +
                     "where pa.IdEmpleado = e.IdEmpleado ";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
      public void insertar(Pago pa) {
        String sql = "insert into pago (IdEmpleado,FechaInicio,Valor,Descripcion,FechaFin) values(?,?,?,?,?)";
        jdbctemplate.update(sql,pa.getIdEmpleado(),pa.getFechaInicio(),pa.getValor(),pa.getDescripcion(),pa.getFechaFin());
    }
     public List buscar(int IdPago) {
        String sql = "select * from pago where IdPago=" + IdPago;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Pago pa) {
        String sql = "update pago set IdEmpleado=?,FechaInicio=?,Valor=?,Descripcion=?,FechaFin=? where IdPago=?";
        jdbctemplate.update(sql,pa.getIdEmpleado(),pa.getFechaInicio(),pa.getValor(),pa.getDescripcion(),pa.getFechaFin(),pa.getIdPago());
    }
    
     public void eliminar(int IdPago) {
        String sql = "Delete From pago where  IdPago=" + IdPago;
        this.jdbctemplate.update(sql);
    }
}
