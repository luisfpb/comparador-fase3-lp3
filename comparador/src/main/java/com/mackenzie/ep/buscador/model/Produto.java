package com.mackenzie.ep.buscador.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="produto")
public class Produto implements Serializable, Comparable<Produto>{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		private int idProduto;
		@Column(name = "nome")
	    private String nome;
		@Column(name = "descricao")
		private String descricao;
		@Column(name = "valor")
		private double valor;
		@Column(name = "idSku")
	    private int idSku;
	    @JoinColumn(name = "idLoja", referencedColumnName = "idLoja")
	    private Loja idLoja;
	   
	    
	    	
	    
		public Produto() {
			super();
		}



		public Produto(int idProduto, String nome, String descricao,
				double valor, int idSku, Loja idLoja) {
			super();
			this.idProduto = idProduto;
			this.nome = nome;
			this.descricao = descricao;
			this.valor = valor;
			this.idSku = idSku;
			this.idLoja = idLoja;
		}



		public int getIdProduto() {
			return idProduto;
		}



		public void setIdProduto(int idProduto) {
			this.idProduto = idProduto;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getDescricao() {
			return descricao;
		}



		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}



		public double getValor() {
			return valor;
		}



		public void setValor(double valor) {
			this.valor = valor;
		}


		public Loja getIdLoja() {
			return idLoja;
		}



		public void setIdLoja(Loja idLoja) {
			this.idLoja = idLoja;
		}



		public int getIdSku() {
			return idSku;
		}



		public void setIdSku(int idSku) {
			this.idSku = idSku;
		}



		@Override
		public String toString() {
			return "Produto [idProduto=" + idProduto + ", nome=" + nome
					+ ", descricao=" + descricao + ", valor=" + valor
					+ ", idSku=" + idSku + ", idLoja=" + idLoja + "]";
		}

		public int compareTo(Produto compareProduto) {
			 
			double compareValor = ((Produto) compareProduto).getValor(); 
	 
			return (int) (compareValor - this.valor);
	 
		}

		
}

