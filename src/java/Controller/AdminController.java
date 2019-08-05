/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.MesaBL;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sebastianrojas
 */
public class AdminController {
    ModelAndView mav = new ModelAndView();
    MesaBL mesabl = new MesaBL();
    int IdMesa;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("indexAdmin.htm")
    public ModelAndView Listar() {
        datos = mesabl.listar();//Instanciar clase de negocio
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("indexAdmin");
        return mav;
    }

}
