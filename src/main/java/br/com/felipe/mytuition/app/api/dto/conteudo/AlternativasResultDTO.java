package br.com.felipe.mytuition.app.api.dto.conteudo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlternativasResultDTO implements Serializable {

	private static final long serialVersionUID = -6390924135299433266L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "ordem")
	private Integer ordem;

	@JsonProperty(value = "texto")
	private String texto;

	@JsonProperty(value = "certo")
	private Boolean certo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
