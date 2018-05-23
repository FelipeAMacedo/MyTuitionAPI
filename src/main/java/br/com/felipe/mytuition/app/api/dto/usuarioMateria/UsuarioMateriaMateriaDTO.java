package br.com.felipe.mytuition.app.api.dto.usuarioMateria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioMateriaMateriaDTO implements Serializable {

	private static final long serialVersionUID = -6758262532938344032L;
	
	@JsonProperty(value = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}