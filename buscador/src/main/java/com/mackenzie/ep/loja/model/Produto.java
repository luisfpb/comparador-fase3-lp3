package com.mackenzie.ep.loja.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "produto")
public class Produto{

	    private int idProduto;
	    private String nome;
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

