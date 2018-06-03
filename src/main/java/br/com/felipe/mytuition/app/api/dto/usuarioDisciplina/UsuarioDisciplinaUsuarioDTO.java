package br.com.felipe.mytuition.app.api.dto.usuarioDisciplina;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDisciplinaUsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 5018490139026882183L;
	
	@JsonProperty(value = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
