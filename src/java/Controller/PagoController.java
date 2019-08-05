/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.EmpleadoBL;
import Business.PagoBL;
import Model.Pago;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class PagoController {
       ModelAndView mav = new ModelAndView();
    PagoBL pagobl = new PagoBL();
    EmpleadoBL empleadobl = new EmpleadoBL();
    int IdPago;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexPago.htm")

    public ModelAndView Listar() {
        datos = pagobl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexPago");
        return mav;
    }

    @RequestMapping(value = "agregarPago.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Pago());
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.addObject("listaE", datos);//Adicionar lista al ModelAndView
        mav.setViewName("agregarPago");
        return mav;
    }

    @RequestMapping(value = "agregarPago.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Pago pa) {

        pagobl.insertar(pa);
        return new ModelAndView("redirect:/indexPago.htm");
    }

    @RequestMapping(value = "editarPago.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdPago = Integer.parseInt(request.getParameter("IdPago"));
        datos = pagobl.buscar(IdPago);
        mav.addObject("lista", datos);
        mav.setViewName("editarPago");
        return mav;
    }

    @RequestMapping(value = "editarPago.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Pago pa) {
        pagobl.actualizar(pa);
        return new ModelAndView("redirect:/indexPago.htm");
    }

    @RequestMapping("deletePago.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdPago = Integer.parseInt(request.getParameter("IdPago"));
        pagobl.eliminar(IdPago);
        return new ModelAndView("redirect:/indexPago.htm");
    }
}
