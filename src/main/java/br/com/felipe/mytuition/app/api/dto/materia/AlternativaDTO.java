package br.com.felipe.mytuition.app.api.dto.materia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlternativaDTO implements Serializable {

	private static final long serialVersionUID = -5427400437011577513L;

	@JsonProperty(value = "ordem")
	private Integer ordem;

	@JsonProperty(value = "texto")
	private String texto;

	@JsonProperty(value = "certo")
	private Boolean certo;

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getCerto() {
		return certo;
	}

	public void setCerto(Boolean certo) {
		this.certo = certo;
	}

}
