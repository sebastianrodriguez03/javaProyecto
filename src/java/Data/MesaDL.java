/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Mesa;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class MesaDL {
    Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "select * from mesa";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
      public void insertar(Mesa m) {
        String sql = "insert into mesa ( NumeroPersonas) values(?)";
        jdbctemplate.update(sql,m.getNumeroPersonas());
    }
     public List buscar(int IdMesa) {
        String sql = "select * from mesa where IdMesa=" + IdMesa;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Mesa m) {
        String sql = "update mesa set NumeroPersonas=? where IdMesa=?";
        jdbctemplate.update(sql,m.getNumeroPersonas(),m.getIdMesa());
    }
     public void eliminar(int IdMesa) {
        String sql = "Delete From mesa where  IdMesa=" + IdMesa;
        this.jdbctemplate.update(sql);
    }
}
