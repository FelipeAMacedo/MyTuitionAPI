package br.com.felipe.mytuition.app.api.dto.materia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.enumerations.Atributo;

public class MateriaResultDTO implements Serializable {

	private static final long serialVersionUID = -8729032093983945789L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "pontos")
	private Integer pontos;

	@JsonProperty(value = "atributo")
	private Atributo atributo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

}