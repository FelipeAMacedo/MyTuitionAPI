package br.com.felipe.mytuition.app.api.dto.conquista;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConquistaDTO implements Serializable {

	private static final long serialVersionUID = 7405630745140496442L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "descricao")
	private String descricao;

	@JsonProperty(value = "imagem")
	private String imagem;

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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
