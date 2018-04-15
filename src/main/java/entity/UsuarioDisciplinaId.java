package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioDisciplinaId implements Serializable {

	private static final long serialVersionUID = 5194698684021449931L;

	@Column(name = "id_usuario")
	private Long usuarioId;

	@Column(name = "id_conquista")
	private Long conquistaId;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getConquistaId() {
		return conquistaId;
	}

	public void setConquistaId(Long conquistaId) {
		this.conquistaId = conquistaId;
	}

}
