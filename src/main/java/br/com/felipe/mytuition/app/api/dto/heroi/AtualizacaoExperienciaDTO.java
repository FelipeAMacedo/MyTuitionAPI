package br.com.felipe.mytuition.app.api.dto.heroi;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtualizacaoExperienciaDTO implements Serializable {

	private static final long serialVersionUID = 5139843617220555968L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "pontosAdicionais")
	private Integer pontosAdicionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPontosAdicionais() {
		return pontosAdicionais;
	}

	public void setPontosAdicionais(Integer pontosAdicionais) {
		this.pontosAdicionais = pontosAdicionais;
	}

}
