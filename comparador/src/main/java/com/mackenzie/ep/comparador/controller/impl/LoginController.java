package com.mackenzie.ep.comparador.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;

import com.mackenzie.ep.buscador.model.Usuario;
import com.mackenzie.ep.comparador.controller.AbstractController;
import com.mackenzie.ep.comparador.dao.BdDao;

public class LoginController extends AbstractController {
	public void execute() {
		try {
//			Usuario user = new Usuario();
//			user.setLogin(getRequest().getParameter("login"));
//			user.setSenha(getRequest().getParameter("senha"));
//
//			BdDao bddao = new BdDao();
//			//Boolean logged = bddao.logged(user);
//			if(logged){
//	            Cookie loginCookie = new Cookie("user",user.getNome());
//	            //setting cookie to expiry in 30 mins
//	            loginCookie.setMaxAge(30*60);
//	           
//	            //this.getResponse().addCookie(loginCookie);
//	            this.setReturnPage("/comparador.jsp");
//				this.getRequest().setAttribute("logged", logged);
//	        }else{
//	        	this.setReturnPage("/login.jsp");
//				this.getRequest().setAttribute("logged", logged);
//	        }
		
			
	        
			
		
		} catch (Exception ex) {
			Logger.getLogger(ComparaProdutoController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

}
