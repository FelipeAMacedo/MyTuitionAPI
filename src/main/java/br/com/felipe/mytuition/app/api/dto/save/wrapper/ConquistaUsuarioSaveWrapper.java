package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaUsuarioDTO;

public class ConquistaUsuarioSaveWrapper implements Serializable {

	private static final long serialVersionUID = -2398192563883166969L;

	@JsonProperty(value = "conquista")
	private ConquistaUsuarioDTO conquistaUsuarioDTO;

	public ConquistaUsuarioDTO getConquistaUsuarioDTO() {
		return conquistaUsuarioDTO;
	}

	public void setConquistaUsuarioDTO(ConquistaUsuarioDTO conquistaUsuarioDTO) {
		this.conquistaUsuarioDTO = conquistaUsuarioDTO;
	}

}
