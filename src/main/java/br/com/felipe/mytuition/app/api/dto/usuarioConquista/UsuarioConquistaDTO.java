package br.com.felipe.mytuition.app.api.dto.usuarioConquista;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.felipe.mytuition.app.utils.LocalDateDeserializer;

public class UsuarioConquistaDTO implements Serializable {
	
	private static final long serialVersionUID = 811750374272395175L;

	@JsonProperty(value = "usuario")
    private UsuarioConquistaUsuarioDTO usuario;

    @JsonProperty(value = "conquista")
    private UsuarioConquistaConquistaDTO conquista;

    @JsonProperty(value = "dataConquista")
	@JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dataConquista;

    public UsuarioConquistaUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioConquistaUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioConquistaConquistaDTO getConquista() {
        return conquista;
    }

    public void setConquista(UsuarioConquistaConquistaDTO conquista) {
        this.conquista = conquista;
    }

    public LocalDate getDataConquista() {
        return dataConquista;
    }

    public void setDataConquista(LocalDate dataConquista) {
        this.dataConquista = dataConquista;
    }
}
