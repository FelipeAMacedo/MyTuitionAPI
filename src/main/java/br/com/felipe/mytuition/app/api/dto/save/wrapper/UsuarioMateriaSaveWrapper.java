package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.usuarioMateria.UsuarioMateriaDTO;

public class UsuarioMateriaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -1043716685069286330L;

	@JsonProperty(value = "usuarioMateria")
	private UsuarioMateriaDTO usuarioMateriaDTO;

	public UsuarioMateriaDTO getUsuarioMateriaDTO() {
		return usuarioMateriaDTO;
	}

	public void setUsuarioMateriaDTO(UsuarioMateriaDTO usuarioMateriaDTO) {
		this.usuarioMateriaDTO = usuarioMateriaDTO;
	}

}
