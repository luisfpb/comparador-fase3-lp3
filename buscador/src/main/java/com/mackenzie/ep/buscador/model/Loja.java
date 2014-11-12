package com.mackenzie.ep.buscador.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Loja")
public class Loja implements Serializable{
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue
	private int idLoja;
	@Column(name = "nome")
	private String nome;
	@Column(name = "endPoint")
	private String endPoint;
	
	public int getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public String toString() {
		return "Loja [idLoja=" + idLoja + ", nome=" + nome + ", endPoint="
				+ endPoint + "]";
	}
	
}
