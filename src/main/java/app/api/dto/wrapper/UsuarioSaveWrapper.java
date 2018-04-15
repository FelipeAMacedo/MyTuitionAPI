package app.api.dto.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import app.api.dto.UsuarioDTO;

public class UsuarioSaveWrapper implements Serializable {

	private static final long serialVersionUID = -8548942540740875853L;

	@JsonProperty("usuario")
	private UsuarioDTO usuarioDTO;

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
