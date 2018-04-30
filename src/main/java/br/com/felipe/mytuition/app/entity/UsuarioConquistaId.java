package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioConquistaId implements Serializable {

	private static final long serialVersionUID = -5905347524538446377L;

	@Column(name = "id_usuario")
	private String usuarioId;

	@Column(name = "id_conquista")
	private Long conquistaId;

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getConquistaId() {
		return conquistaId;
	}

	public void setConquistaId(Long conquistaId) {
		this.conquistaId = conquistaId;
	}

}
