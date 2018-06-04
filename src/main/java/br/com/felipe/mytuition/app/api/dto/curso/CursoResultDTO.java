package br.com.felipe.mytuition.app.api.dto.curso;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CursoResultDTO implements Serializable {

	private static final long serialVersionUID = 873201692083018853L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "descricao")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
