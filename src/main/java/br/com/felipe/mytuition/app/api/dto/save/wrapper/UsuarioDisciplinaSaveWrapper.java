package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.usuarioDisciplina.UsuarioDisciplinaDTO;

public class UsuarioDisciplinaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -5997434109069818107L;

	@JsonProperty(value = "usuarioDisciplina")
	private UsuarioDisciplinaDTO usuarioDisciplinaDTO;

	public UsuarioDisciplinaDTO getUsuarioDisciplinaDTO() {
		return usuarioDisciplinaDTO;
	}

	public void setUsuarioDisciplinaDTO(UsuarioDisciplinaDTO usuarioDisciplinaDTO) {
		this.usuarioDisciplinaDTO = usuarioDisciplinaDTO;
	}

}
