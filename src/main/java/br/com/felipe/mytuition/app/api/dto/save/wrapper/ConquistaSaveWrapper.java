package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaDTO;

public class ConquistaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -4920205047270404229L;

	@JsonProperty("conquista")
	private ConquistaDTO conquistaDTO;

	public ConquistaDTO getConquistaDTO() {
		return conquistaDTO;
	}

	public void setConquistaDTO(ConquistaDTO conquistaDTO) {
		this.conquistaDTO = conquistaDTO;
	}

}
