package br.com.felipe.mytuition.app.api.dto.usuarioConquista;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioConquistaUsuarioDTO implements Serializable {

	private static final long serialVersionUID = -9153472313134066644L;

	@JsonProperty(value = "email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
