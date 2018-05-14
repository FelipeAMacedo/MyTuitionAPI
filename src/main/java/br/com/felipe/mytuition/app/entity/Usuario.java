package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.felipe.mytuition.app.enumerations.Perfil;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -8533122513715515843L;

	@Id
	private String email;

	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	private Heroi heroi;

	@OneToOne(cascade = CascadeType.ALL)
	private Aluno aluno;

	@Enumerated
	private Perfil perfil = Perfil.ALUNO;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Set<Ataque> ataque = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioConteudo> usuarioConteudo = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioConquista> usuarioConquista = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioDisciplina> usuarioDisciplina = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioMateria> usuarioMateria = new HashSet<>(0);
	
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

	public Set<UsuarioConteudo> getUsuarioConteudo() {
		return usuarioConteudo;
	}

	public void setUsuarioConteudo(Set<UsuarioConteudo> usuarioConteudo) {
		this.usuarioConteudo = usuarioConteudo;
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

	public Set<UsuarioMateria> getUsuarioMateria() {
		return usuarioMateria;
	}

	public void setUsuarioMateria(Set<UsuarioMateria> usuarioMateria) {
		this.usuarioMateria = usuarioMateria;
	}
}
