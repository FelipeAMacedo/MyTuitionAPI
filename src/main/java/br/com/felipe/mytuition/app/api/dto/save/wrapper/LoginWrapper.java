package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.LoginDTO;

public class LoginWrapper implements Serializable {

	private static final long serialVersionUID = -8548942540740875853L;

	@JsonProperty(value = "usuario")
	private LoginDTO loginDTO;

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

}
