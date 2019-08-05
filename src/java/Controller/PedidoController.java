/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.ClienteBL;
import Business.EmpleadoBL;
import Business.MesaBL;
import Business.PedidoBL;
import Model.Pedido;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class PedidoController {
         //-----Atributos de la clase--------//
    ModelAndView mav = new ModelAndView();
    PedidoBL pedidobl = new PedidoBL();
    ClienteBL clientebl = new ClienteBL();
    EmpleadoBL empleadobl = new EmpleadoBL();
    MesaBL mesabl = new MesaBL();
    int IdPedido;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexPedido.htm")

    public ModelAndView Listar() {
        datos = pedidobl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexPedido");
        return mav;
    }

    @RequestMapping(value = "agregarPedido.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Pedido());
        datos = clientebl.listar();//Instanciar clase de negocio
        mav.addObject("listaC", datos);//Adicionar lista al ModelAndView
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.addObject("listaE", datos);//Adicionar lista al ModelAndView
        datos = mesabl.listar();//Instanciar clase de negocio
        mav.addObject("listaM", datos);
        mav.setViewName("agregarPedido");
        return mav;
    }

    @RequestMapping(value = "agregarPedido.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Pedido p) {

        pedidobl.insertar(p);
        return new ModelAndView("redirect:/indexPedido.htm");
    }

    @RequestMapping(value = "editarPedido.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdPedido = Integer.parseInt(request.getParameter("IdPedido"));
        datos = clientebl.listar();//Instanciar clase de negocio//Instanciar clase de negocio
        mav.addObject("listaC", datos);
        datos = empleadobl.listar();//Instanciar clase de negocio
        mav.addObject("listaE", datos);
        datos = mesabl.listar();//Instanciar clase de negocio
        mav.addObject("listaM", datos);
        datos = pedidobl.buscar(IdPedido);
        mav.addObject("lista", datos);
        mav.setViewName("editarPedido");
        return mav;
    }

    @RequestMapping(value = "editarPedido.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Pedido p) {
        pedidobl.actualizar(p);
        return new ModelAndView("redirect:/indexPedido.htm");
    }

    @RequestMapping("deletePedido.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdPedido = Integer.parseInt(request.getParameter("IdPedido"));
        pedidobl.eliminar(IdPedido);
        return new ModelAndView("redirect:/indexPedido.htm");
    }
    
}
