package br.com.felipe.mytuition.app.api.dto.usuarioConquista;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioConquistaConquistaDTO implements Serializable {

	private static final long serialVersionUID = 1995002464257152135L;

	@JsonProperty(value = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
