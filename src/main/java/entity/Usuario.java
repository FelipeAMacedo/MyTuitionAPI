package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enumerations.Perfil;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -8533122513715515843L;

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String senha;

	@OneToOne
	private Heroi heroi;

	@OneToOne
	private Aluno aluno;

	@Enumerated
	private Perfil perfil;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Ataque> ataque;

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true)
	private Set<UsuarioExercicio> usuarioExercicio = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true)
	private Set<UsuarioConquista> usuarioConquista = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true)
	private Set<UsuarioDisciplina> usuarioDisciplina = new HashSet<>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<Ataque> getAtaque() {
		return ataque;
	}

	public void setAtaque(Set<Ataque> ataque) {
		this.ataque = ataque;
	}

	public Set<UsuarioExercicio> getUsuarioExercicio() {
		return usuarioExercicio;
	}

	public void setUsuarioExercicio(Set<UsuarioExercicio> usuarioExercicio) {
		this.usuarioExercicio = usuarioExercicio;
	}

	public Set<UsuarioConquista> getUsuarioConquista() {
		return usuarioConquista;
	}

	public void setUsuarioConquista(Set<UsuarioConquista> usuarioConquista) {
		this.usuarioConquista = usuarioConquista;
	}

	public Set<UsuarioDisciplina> getUsuarioDisciplina() {
		return usuarioDisciplina;
	}

	public void setUsuarioDisciplina(Set<UsuarioDisciplina> usuarioDisciplina) {
		this.usuarioDisciplina = usuarioDisciplina;
	}
}
