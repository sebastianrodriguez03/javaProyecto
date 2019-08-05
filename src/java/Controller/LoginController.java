/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.LoginBL;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Usuario
 */
public class LoginController {
      ModelAndView mav = new ModelAndView();
    LoginBL loginbl = new LoginBL();
    int IdMesa;
    List datos;

    //----Nombre para la url del navegador----
    @RequestMapping("login.htm")
    public ModelAndView Listar() {
    
        mav.addObject("lista", datos);//Adicionar lista al ModelAndView
        mav.setViewName("login");
        return mav;
    }
    
}
