package br.com.felipe.mytuition.app.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloDTO implements Serializable {

	private static final long serialVersionUID = -4674640517024494805L;
	
	@JsonProperty("nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
}
