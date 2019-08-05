/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CargoBL;
import Business.EmpleadoBL;
import Model.Empleado;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class EmpleadoController {
        //-----Atributos de la clase--------//
    ModelAndView mav = new ModelAndView();
    EmpleadoBL empleadobl = new EmpleadoBL();
    CargoBL cargobl = new CargoBL();
    int IdEmpleado;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexEmpleado.htm")

    public ModelAndView Listar() {
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexEmpleado");
        return mav;
    }

    @RequestMapping(value = "agregarEmpleado.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Empleado());
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.addObject("listaCA", datos);//Adicionar lista al ModelAndView
        datos = cargobl.listar();//Instanciar clase de negocio
        mav.setViewName("agregarEmpleado");
        return mav;
    }

    @RequestMapping(value = "agregarEmpleado.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Empleado e) {

        empleadobl.insertar(e);
        return new ModelAndView("redirect:/indexEmpleado.htm");
    }

    @RequestMapping(value = "editarEmpleado.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdEmpleado = Integer.parseInt(request.getParameter("IdEmpleado"));
        datos = empleadobl.listar();//Instanciar clase de negocio//Instanciar clase de negocio
        mav.addObject("listaC", datos);
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.setViewName("editarEmpleado");
        return mav;
    }

    @RequestMapping(value = "editarEmpleado.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Empleado e) {
        empleadobl.actualizar(e);
        return new ModelAndView("redirect:/indexEmpleado.htm");
    }

    @RequestMapping("deleteEmpleado.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdEmpleado = Integer.parseInt(request.getParameter("IdEmpleado"));
        empleadobl.eliminar(IdEmpleado);
        return new ModelAndView("redirect:/indexEmpleado.htm");
    }
}
