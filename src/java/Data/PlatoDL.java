/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Plato;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class PlatoDL {
     Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "select * from plato";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }

    public void insertar(Plato pl) {
        String sql = "insert into plato (NombrePlato,Precio,Descripcion) values(?,?,?)";
        jdbctemplate.update(sql,pl.getNombrePlato(),pl.getPrecio(),pl.getDescripcion());
    }

    public List buscar(int IdPlato) {
        String sql = "select * from plato where IdPlato=" + IdPlato;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Plato pl) {
        String sql = "update plato set NombrePlato=?,Precio=?, Descripcion=? where IdPlato=?";
        jdbctemplate.update(sql,pl.getNombrePlato(),pl.getPrecio(),pl.getDescripcion(),pl.getIdPlato());
    }
    
   public void eliminar(int IdPlato) {
        String sql = "Delete From plato where IdPlato=" + IdPlato;
        this.jdbctemplate.update(sql);
    }   
    
}
