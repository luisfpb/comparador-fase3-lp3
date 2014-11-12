package com.mackenzie.ep.buscador.model;

import java.util.List;

public class Produtos {
	private List<Produto> produto;
	
	public Produtos(List<Produto> produto) {
		super();
		this.produto = produto;
	}
	
	public Produtos(Produtos produto) {
		super();
		this.produto = produto.getProduto();
	}
	
	public Produtos(){
		super();
	}
	
	public List<Produto> getProduto() {
		return produto;
	}
	
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "Produtos [produto=" + produto + "]";
	}
}