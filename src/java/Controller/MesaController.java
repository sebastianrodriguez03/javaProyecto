/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.MesaBL;
import Model.Mesa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class MesaController {
      ModelAndView mav = new ModelAndView();
    MesaBL mesabl = new MesaBL();
    int IdMesa;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexMesa.htm")

    public ModelAndView Listar() {
        datos = mesabl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexMesa");
        return mav;
    }

    @RequestMapping(value = "agregarMesa.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Mesa());
        datos = mesabl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("agregarMesa");
        return mav;
    }

    @RequestMapping(value = "agregarMesa.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Mesa m) {

        mesabl.insertar(m);
        return new ModelAndView("redirect:/indexMesa.htm");
    }

    @RequestMapping(value = "editarMesa.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdMesa = Integer.parseInt(request.getParameter("IdMesa"));
        datos = mesabl.buscar(IdMesa);
        mav.addObject("lista", datos);
        mav.setViewName("editarMesa");
        return mav;
    }

    @RequestMapping(value = "editarMesa.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Mesa m) {
        mesabl.actualizar(m);
        return new ModelAndView("redirect:/indexMesa.htm");
    }

    @RequestMapping("deleteMesa.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdMesa = Integer.parseInt(request.getParameter("IdMesa"));
        mesabl.eliminar(IdMesa);
        return new ModelAndView("redirect:/indexMesa.htm");
    }
}
