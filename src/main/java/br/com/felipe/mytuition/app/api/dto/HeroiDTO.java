package br.com.felipe.mytuition.app.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroiDTO implements Serializable {

	private static final long serialVersionUID = 8121810391676220L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "imagem")
	private String imagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
