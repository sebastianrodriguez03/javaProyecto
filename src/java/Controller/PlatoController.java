/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.PlatoBL;
import Model.Plato;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class PlatoController {
    ModelAndView mav = new ModelAndView();
    PlatoBL platobl = new PlatoBL();
    int IdPlato;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexPlato.htm")

    public ModelAndView Listar() {
        datos = platobl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexPlato");
        return mav;
    }

    @RequestMapping(value = "agregarPlato.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Plato());
        mav.setViewName("agregarPlato");
        return mav;
    }

    @RequestMapping(value = "agregarPlato.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Plato pl) {

        platobl.insertar(pl);
        return new ModelAndView("redirect:/indexPlato.htm");
    }

    @RequestMapping(value = "editarPlato.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdPlato = Integer.parseInt(request.getParameter("IdPlato"));
        datos = platobl.buscar(IdPlato);
        mav.addObject("lista", datos);
        mav.setViewName("editarPlato");
        return mav;
    }

    @RequestMapping(value = "editarPlato.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Plato pl) {
        platobl.actualizar(pl);
        return new ModelAndView("redirect:/indexPlato.htm");
    }

    @RequestMapping("deletePlato.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdPlato = Integer.parseInt(request.getParameter("IdPlato"));
        platobl.eliminar(IdPlato);
        return new ModelAndView("redirect:/indexPlato.htm");
    }
}
