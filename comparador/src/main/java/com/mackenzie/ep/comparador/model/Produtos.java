package com.mackenzie.ep.comparador.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produtos {
	private List<Produto> produtos;
	public Produtos(){
		produtos = new ArrayList<Produto>();
	}
	@XmlElement(name = "produto")
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto) {
		this.produtos.add(produto);
	}
}
