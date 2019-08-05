/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Cargo;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class CargoDL {
     Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "select * from cargo";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
      public void insertar(Cargo ca) {
        String sql = "insert into cargo ( Nombre) values(?)";
        jdbctemplate.update(sql,ca.getNombre());
    }
     public List buscar(int IdCargo) {
        String sql = "select * from cargo where IdCargo=" + IdCargo;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Cargo ca) {
        String sql = "update cargo set Nombre=? where IdCargo=?";
        jdbctemplate.update(sql,ca.getNombre(),ca.getIdCargo());
    }
    
     public void eliminar(int IdCargo) {
        String sql = "Delete From cargo where  IdCargo=" + IdCargo;
        this.jdbctemplate.update(sql);
    }
    
}
