package com.mackenzie.ep.comparador.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mackenzie.ep.buscador.model.Produto;
import com.mackenzie.ep.buscador.model.Produtos;
import com.mackenzie.ep.buscador.model.Usuario;

public class BdDao {
	
	public Produtos getProdutosByTerms(String[] terms){
		EntityManager em =
	            Persistence.createEntityManagerFactory("sample").createEntityManager();
		int i = 0;
		String q = "select p from Produto p where ";
		while(i<terms.length){
			if(i!=0)
				q=q+" AND ";
			q = q + "descricao LIKE '%" + terms[i] + "%'";
			i++;
		}
		Query query = em.createQuery(q, Produto.class);
		ArrayList<Produto> produtoList = (ArrayList<Produto>) query.getResultList();
		System.out.println("\n\n\n"+produtoList+"\n\n\n");
		Produtos produtos = new Produtos(produtoList);
		return produtos;
	}
	
	public Usuario logged(Usuario user){
		EntityManager em =
	            Persistence.createEntityManagerFactory("sample").createEntityManager();
		String q = "select u from Usuario u where login=\'"+user.getLogin()+"\' AND senha=\'"+user.getSenha()+"\'";
		
		Query query = em.createQuery(q, Usuario.class);
		Usuario usuario;
		try {
			usuario = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("\n\n\nnull\n\n\n");
			return null;
		}
		System.out.println("\n\n\n"+usuario+"\n\n\n");
		
		return usuario;
	}
	
	
}
