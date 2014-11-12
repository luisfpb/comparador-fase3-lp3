package com.mackenzie.ep.buscador.client;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mackenzie.ep.buscador.model.Loja;
import com.mackenzie.ep.buscador.model.Produto;
import com.mackenzie.ep.buscador.model.Produtos;
import com.mackenzie.ep.buscador.model.ProdutoParser;

public class BuscadorCliente {
	public static void main(String[] args) {
		
		try {
			while(true){
				ProdutoParser parser = new ProdutoParser();
				EntityManager em =
			            Persistence.createEntityManagerFactory("sample").createEntityManager();
				
				Query query = em.createQuery("select l from Loja l",Loja.class);
				ArrayList<Loja> lojas = (ArrayList<Loja>) query.getResultList();
				
				for(Loja iteratorLoja : lojas){
					ResteasyClient client = new ResteasyClientBuilder().build();
					ResteasyWebTarget target = client.target(iteratorLoja.getEndPoint()
							+ "Produtos");
					Response response = target.request().get();
					if (response.getStatus() != 200) {
						throw new RuntimeException(
								"Failed : HTTP error code : "
										+ response.getStatus());
					}
					JSONObject jsonObject = (JSONObject) new JSONParser()
							.parse(response.readEntity(String.class));
					Produtos produtos = new Produtos(
							parser.parseToList(jsonObject.get("produtos")
									.toString()));

					for (Produto iterator : produtos.getProduto()) {
						iterator.setIdLoja(iteratorLoja);
						iterator.setIdSku(iterator.getIdProduto());
						iterator.setIdProduto(0);

						Query query2 = em.createQuery("select p from Produto p where nome = :nome AND idLoja = :idLoja",Produto.class);
						query2.setParameter("nome", iterator.getNome());
						query2.setParameter("idLoja", iteratorLoja);

						Produto pAux;
						try {
							pAux = (Produto) query2.getSingleResult();
						} catch (Exception e) {
							pAux = null;
						}

						if (pAux == null) {
							System.out.println("Dentro do NULL" + pAux);
							em.getTransaction().begin();
							em.persist(iterator);
							em.getTransaction().commit();
						} else if (pAux.getValor() != iterator.getValor()) {
							iterator.setIdProduto(pAux.getIdProduto());
							System.out.println("Dentro do valor diferente"
									+ iterator);
							em.getTransaction().begin();
							pAux.setValor(iterator.getValor());
							em.getTransaction().commit();
						}
						System.out.println("Fora de TUDO nao Persiste"
								+ iterator);
					}

					response.close();
					em.close();
				}
				Thread.sleep(30000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
