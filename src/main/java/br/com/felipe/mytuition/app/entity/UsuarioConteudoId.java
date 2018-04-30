package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioConteudoId implements Serializable {

	private static final long serialVersionUID = -5792908029997332776L;

	@Column(name = "id_usuario")
	private Long usuarioId;
	
	@Column(name = "id_conteudo")
	private Long conteudoId;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getConteudoId() {
		return conteudoId;
	}

	public void setConteudoId(Long conteudoId) {
		this.conteudoId = conteudoId;
	}

}
