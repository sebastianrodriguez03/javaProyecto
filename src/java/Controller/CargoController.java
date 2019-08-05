/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.CargoBL;
import Model.Cargo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class CargoController { 
    ModelAndView mav = new ModelAndView();
    CargoBL cargoebl = new CargoBL();
    int IdCargo;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexCargo.htm")

    public ModelAndView Listar() {
        datos = cargoebl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexCargo");
        return mav;
    }

    @RequestMapping(value = "agregarCargo.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Cargo());
        mav.setViewName("agregarCargo");
        return mav;
    }

    @RequestMapping(value = "agregarCargo.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Cargo ca) {

        cargoebl.insertar(ca);
        return new ModelAndView("redirect:/indexCargo.htm");
    }

    @RequestMapping(value = "editarCargo.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdCargo = Integer.parseInt(request.getParameter("IdCargo"));
        datos = cargoebl.buscar(IdCargo);
        mav.addObject("lista", datos);
        mav.setViewName("editarCargo");
        return mav;
    }

    @RequestMapping(value = "editarCargo.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Cargo ca) {
        cargoebl.actualizar(ca);
        return new ModelAndView("redirect:/indexCargo.htm");
    }

    @RequestMapping("deleteCargo.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdCargo = Integer.parseInt(request.getParameter("IdCargo"));
        cargoebl.eliminar(IdCargo);
        return new ModelAndView("redirect:/indexCargo.htm");
    }
}
