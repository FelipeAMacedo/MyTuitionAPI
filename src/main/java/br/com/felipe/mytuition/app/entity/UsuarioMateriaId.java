package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioMateriaId implements Serializable {

	private static final long serialVersionUID = 5194698684021449931L;

	@Column(name = "id_usuario")
	private String usuarioId;

	@Column(name = "id_materia")
	private Long materiaId;

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(Long materiaId) {
		this.materiaId = materiaId;
	}

}
