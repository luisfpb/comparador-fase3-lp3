package com.mackenzie.ep.comparador.rest;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mackenzie.ep.comparador.dao.ProdutoDao;
import com.mackenzie.ep.comparador.model.Produto;
import com.mackenzie.ep.comparador.model.Produtos;

@Path("/services")
public class ProdutoService {

	@GET
	@Path("/Produtos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProdutos() {
		ProdutoDao produtodao = new ProdutoDao();
		Produtos produtos = produtodao.getProdutos();
		return Response.status(Response.Status.OK).entity(produtos).build();
	}

	@GET
	@Path("/Produto/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProduto(@PathParam("id") int idProduto) {
		ProdutoDao produtodao = new ProdutoDao();
		Produto produto = produtodao.getProduto(idProduto);
		if(produto == null){
			return Response.status(Response.Status.NOT_FOUND).entity("404 - Not Found").build();
		}
		return Response.status(Response.Status.OK).entity(produto).build();
	}

}


