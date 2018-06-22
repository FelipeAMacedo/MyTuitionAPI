package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.heroi.AumentarPontosDTO;

public class AumentarPontosWrapper implements Serializable {

	private static final long serialVersionUID = 8324712382508571605L;

	@JsonProperty(value = "heroi")
	private AumentarPontosDTO aumentarPontosDTO;

	public AumentarPontosDTO getAumentarPontosDTO() {
		return aumentarPontosDTO;
	}

	public void setAumentarPontosDTO(AumentarPontosDTO aumentarPontosDTO) {
		this.aumentarPontosDTO = aumentarPontosDTO;
	}
}
