package br.com.felipe.mytuition.app.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 5598598162297350726L;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "senha")
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
