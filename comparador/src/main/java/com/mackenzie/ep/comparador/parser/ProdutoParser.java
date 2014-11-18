package com.mackenzie.ep.comparador.parser;

import com.google.gson.Gson;
import com.mackenzie.ep.buscador.model.Produto;
import com.mackenzie.ep.buscador.model.Produtos;


public class ProdutoParser {

		public String parseToJson(Produto produto) {
			Gson gson = new Gson();
			return gson.toJson(produto);
		}
		
		public String parseToListJson(Produtos produtos) {
			Gson gson = new Gson();
			return gson.toJson(produtos);
		}
		
		public Produto parse(String json) {
			Gson gson = new Gson();
			return gson.fromJson(json, Produto.class);
		}

		public Produtos parseToList(String json) {
			Gson gson = new Gson();
			return gson.fromJson(json, Produtos.class);
		}
		
}