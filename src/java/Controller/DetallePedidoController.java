/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.DetallePedidoBL;
import Business.PedidoBL;
import Business.PlatoBL;
import Model.DetallePedido;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class DetallePedidoController {
    ModelAndView mav = new ModelAndView();
    DetallePedidoBL detallepedidobl = new DetallePedidoBL();
    PlatoBL platobl = new PlatoBL();
    PedidoBL pedidobl = new PedidoBL();
    int IdDetallePedido;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexDetallePedido.htm")

    public ModelAndView Listar() {
        datos = detallepedidobl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexDetallePedido");
        return mav;
    }

    @RequestMapping(value = "agregarDetallePedido.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new DetallePedido());
       //Adicionar lista al ModelAndView
        datos = platobl.listar();//Instanciar clase de negocio
        mav.addObject("listaPl", datos);//Adicionar lista al ModelAndView
        datos = pedidobl.listar();
        mav.addObject("listaP", datos);
        //Instanciar clase de negocio
        mav.setViewName("agregarDetallePedido");
        return mav;
    }

    @RequestMapping(value = "agregarDetallePedido.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(DetallePedido dp) {

        detallepedidobl.insertar(dp);
        return new ModelAndView("redirect:/indexDetallePedido.htm");
    }

    @RequestMapping(value = "editarDetallePedido.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdDetallePedido = Integer.parseInt(request.getParameter("IdDetallePedido"));//Instanciar clase de negocio//Instanciar clase de negocio
       
        datos = platobl.listar();//Instanciar clase de negocio
        mav.addObject("listaPl", datos);
        datos = pedidobl.listar();//Instanciar clase de negocio
        mav.addObject("listaP", datos);
        mav.setViewName("editarDetallePedido");
        return mav;
    }

    @RequestMapping(value = "editarDetallePedido.htm", method = RequestMethod.POST)
    public ModelAndView Editar(DetallePedido dp) {
        detallepedidobl.actualizar(dp);
        return new ModelAndView("redirect:/indexDetallePedido.htm");
    }

    @RequestMapping("deleteDetallePedido.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdDetallePedido = Integer.parseInt(request.getParameter("IdDetallePedido"));
        detallepedidobl.eliminar(IdDetallePedido);
        return new ModelAndView("redirect:/indexDetallePedido.htm");
    }
}
