package com.mackenzie.ep.buscador.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Produto")
@XmlRootElement(name = "produto")
public class Produto implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@Column(name = "idProduto")
		private int idProduto;
		@Column(name = "nome")
	    private String nome;
		@JoinColumn(name = "idLoja", referencedColumnName = "idLoja")
	    private Loja idLoja;
		@Column( name = "idSku")
		private int idSku;
	    @Column(name = "descricao")
		private String descricao;
	    
	    private Double valor;
	    
	    @XmlElement
	    public int getIdProduto() {
	        return idProduto;
	    }

	    public void setIdProduto(int idProduto) {
	        this.idProduto = idProduto;
	    }
	    
	    @XmlElement
	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    
	    @XmlElement
	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }
	    
	    @XmlElement
	    public Double getValor() {
	        return valor;
	    }

	    public void setValor(Double valor) {
	        this.valor = valor;
	    }
}

