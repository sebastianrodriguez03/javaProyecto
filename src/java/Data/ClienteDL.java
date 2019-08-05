/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Cliente;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class ClienteDL {  
    Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "select * from cliente";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }

    public void insertar(Cliente c) {
        String sql = "insert into cliente ( Nombre,Apellido,Direccion,Telefono) values(?,?,?,?)";
        jdbctemplate.update(sql, c.getNombre(),c.getApellido() , c.getDireccion(), c.getTelefono());
    }

    public List buscar(int IdCliente) {
        String sql = "select * from cliente where IdCliente=" + IdCliente;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Cliente c) {
        String sql = "update cliente set Nombre=?,Apellido=?,Direccion=?,Telefono=? where IdCliente=?";
        jdbctemplate.update(sql, c.getNombre(),c.getApellido() , c.getDireccion(), c.getTelefono(),c.getIdCliente());
    }

    public void eliminar(int IdCliente) {
        String sql = "Delete From cliente where  IdCliente=" + IdCliente;
        this.jdbctemplate.update(sql);
    }
}
