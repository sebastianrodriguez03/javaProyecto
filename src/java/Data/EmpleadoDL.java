/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Empleado;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Usuario
 */
public class EmpleadoDL {
        Conexion con =  new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.conectar());
    List datos;

    public List listar() {
        String sql = "SELECT e.Nombre as Empleados,e.Apellido,e.Documento, ca.Nombre as Cargo\n" +
                     "from empleado e, cargo ca\n" +
                     "where e.IdCargo = ca.IdCargo";
        datos = jdbctemplate.queryForList(sql);
        return datos;
    }
      public void insertar(Empleado e) {
        String sql = "insert into empleado (IdCargo,Nombre,Apellido,Documento) values(?,?,?,?)";
        jdbctemplate.update(sql,e.getIdCargo(),e.getNombre(),e.getApellido(),e.getDocumento());
    }
    public List buscar(int IdEmpleado) {
        String sql = "select * from empleado where IdEmpleado=" + IdEmpleado;
        datos = this.jdbctemplate.queryForList(sql);
        return datos;
    }

    public void actualizar(Empleado e) {
        String sql = "update empleado set IdCargo=?,Nombre=?,Apellido=?,Documento=? where IdEmpleado=?";
        jdbctemplate.update(sql,e.getIdCargo(),e.getNombre(),e.getApellido(),e.getDocumento(),e.getIdEmpleado());
    }
    public void eliminar(int IdEmpleado) {
        String sql = "Delete From empleado where IdEmpleado=" + IdEmpleado;
        this.jdbctemplate.update(sql);
    }   
  
}
