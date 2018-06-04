package br.com.felipe.mytuition.app.api.dto.usuarioConquista;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeSerializer;

public class UsuarioConquistaResultDTO implements Serializable {

	private static final long serialVersionUID = 1282296078373874907L;

	@JsonProperty(value = "conquista")
	private UsuarioConquistaConquistaDTO conquista;

	@JsonProperty(value = "usuario")
	private UsuarioConquistaUsuarioDTO usuario;

	@JsonProperty(value = "inicio")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime inicio;

	@JsonProperty(value = "conclusao")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime conclusao;

	public UsuarioConquistaConquistaDTO getConquista() {
		return conquista;
	}

	public void setConquista(UsuarioConquistaConquistaDTO conquista) {
		this.conquista = conquista;
	}

	public UsuarioConquistaUsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioConquistaUsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getConclusao() {
		return conclusao;
	}

	public void setConclusao(LocalDateTime conclusao) {
		this.conclusao = conclusao;
	}

}
