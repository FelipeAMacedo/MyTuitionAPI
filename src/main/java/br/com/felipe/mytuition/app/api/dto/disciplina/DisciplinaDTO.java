package br.com.felipe.mytuition.app.api.dto.disciplina;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDTO implements Serializable {

	private static final long serialVersionUID = -7789050597369157033L;

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
