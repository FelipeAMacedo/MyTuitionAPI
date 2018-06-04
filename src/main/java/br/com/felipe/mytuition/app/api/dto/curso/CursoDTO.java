package br.com.felipe.mytuition.app.api.dto.curso;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CursoDTO implements Serializable {

	private static final long serialVersionUID = 7149092590120954100L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "descricao")
	private String descricao;

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

}
