package br.com.felipe.mytuition.app.api.dto.usuarioMateria;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioMateriaUsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = -3108371252478289478L;
	
	@JsonProperty(value = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
