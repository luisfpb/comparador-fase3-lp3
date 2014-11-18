package com.mackenzie.ep.comparador.controller.impl;


import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mackenzie.ep.buscador.model.Produtos;
import com.mackenzie.ep.comparador.controller.AbstractController;
import com.mackenzie.ep.comparador.dao.BdDao;

public class ComparaProdutoController extends AbstractController {
	public void execute() {
		try {
			String term = getRequest().getParameter("term");
			String[] terms = term.split(" ");

			BdDao bddao = new BdDao();
			Produtos produtos = bddao.getProdutosByTerms(terms);
			Collections.sort(produtos.getProduto());
			this.setReturnPage("/comparador.jsp");
			this.getRequest().setAttribute("produtos", produtos);
		} catch (Exception ex) {
			Logger.getLogger(ComparaProdutoController.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

}
