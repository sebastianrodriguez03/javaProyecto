/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.ClienteBL;
import Model.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class ClienteController {
       //-----Atributos de la clase--------//
    ModelAndView mav = new ModelAndView();
    ClienteBL clientebl = new ClienteBL();
    int IdCliente;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexCliente.htm")

    public ModelAndView Listar() {
        datos = clientebl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexCliente");
        return mav;
    }

    @RequestMapping(value = "agregarCliente.htm", method = RequestMethod.GET)

    public ModelAndView Agregar() {

        mav.addObject(new Cliente());
        mav.setViewName("agregarCliente");
        return mav;
    }

    @RequestMapping(value = "agregarCliente.htm", method = RequestMethod.POST)

    public ModelAndView Agregar(Cliente c) {

        clientebl.insertar(c);
        return new ModelAndView("redirect:/indexCliente.htm");
    }

    @RequestMapping(value = "editarCliente.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        IdCliente = Integer.parseInt(request.getParameter("IdCliente"));
        datos = clientebl.buscar(IdCliente);
        mav.addObject("lista", datos);
        mav.setViewName("editarCliente");
        return mav;
    }

    @RequestMapping(value = "editarCliente.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Cliente c) {
        clientebl.actualizar(c);
        return new ModelAndView("redirect:/indexCliente.htm");
    }

    @RequestMapping("deleteCliente.htm")
    public ModelAndView Delete(HttpServletRequest request) {
        IdCliente = Integer.parseInt(request.getParameter("IdCliente"));
        clientebl.eliminar(IdCliente);
        return new ModelAndView("redirect:/indexCliente.htm");
    }
}
