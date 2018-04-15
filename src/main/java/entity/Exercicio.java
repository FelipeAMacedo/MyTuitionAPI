package entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exercicio extends Conteudo implements Serializable {

	private static final long serialVersionUID = -6216301285326219806L;

	private String enunciado;

	@Temporal(TemporalType.TIME)
	private LocalTime duracao;

	@ManyToOne
	private Ataque ataque;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "exercicio", orphanRemoval = true)
	private Set<Alternativa> alternativas = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "exercicio", orphanRemoval = true)
	private Set<UsuarioExercicio> usuarioExercicio = new HashSet<>(0);

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public Ataque getAtaque() {
		return ataque;
	}

	public void setAtaque(Ataque ataque) {
		this.ataque = ataque;
	}

	public Set<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Set<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Set<UsuarioExercicio> getUsuarioExercicio() {
		return usuarioExercicio;
	}

	public void setUsuarioExercicio(Set<UsuarioExercicio> usuarioExercicio) {
		this.usuarioExercicio = usuarioExercicio;
	}

}
