package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioExercicioId implements Serializable {

	private static final long serialVersionUID = -5792908029997332776L;

	@Column(name = "id_usuario")
	private Long usuarioId;
	
	@Column(name = "id_exercicio")
	private Long exercicioId;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getExercicioId() {
		return exercicioId;
	}

	public void setExercicioId(Long exercicioId) {
		this.exercicioId = exercicioId;
	}

}
