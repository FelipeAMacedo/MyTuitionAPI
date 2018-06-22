package br.com.felipe.mytuition.app.api.dto.heroi;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AumentarPontosDTO implements Serializable {

	private static final long serialVersionUID = -5824240580713525771L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "ataque")
	private Integer ataque;

	@JsonProperty(value = "defesa")
	private Integer defesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

}
