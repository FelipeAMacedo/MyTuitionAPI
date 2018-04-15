package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsuarioDisciplina implements Serializable {

	private static final long serialVersionUID = 1486104259405026606L;

	@EmbeddedId
	private UsuarioDisciplinaId id;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime inicio;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime conclusao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_disciplina", nullable = false, insertable = false, updatable = false)
	private Disciplina disciplina;

	public UsuarioDisciplinaId getId() {
		return id;
	}

	public void setId(UsuarioDisciplinaId id) {
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
