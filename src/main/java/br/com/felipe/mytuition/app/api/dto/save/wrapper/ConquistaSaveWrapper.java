package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaSaveDTO;

public class ConquistaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -4920205047270404229L;

	@JsonProperty("conquista")
	private ConquistaSaveDTO conquistaDTO;

	public ConquistaSaveDTO getConquistaDTO() {
		return conquistaDTO;
	}

	public void setConquistaDTO(ConquistaSaveDTO conquistaDTO) {
		this.conquistaDTO = conquistaDTO;
	}

}
