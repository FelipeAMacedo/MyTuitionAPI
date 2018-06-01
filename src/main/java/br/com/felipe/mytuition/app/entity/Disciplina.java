package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -5416749887977124159L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String descricao;

	@OneToMany(mappedBy = "disciplina", orphanRemoval = true)
	private Set<Conquista> conquistas = new HashSet<>(0);

	@OneToMany(mappedBy = "disciplina")
	private Set<Materia> materias = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "disciplina", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioDisciplina> usuarioDisciplina = new HashSet<>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Conquista> getConquistas() {
		return conquistas;
	}

	public void setConquistas(Set<Conquista> conquistas) {
		this.conquistas = conquistas;
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	public Set<UsuarioDisciplina> getUsuarioDisciplina() {
		return usuarioDisciplina;
	}

	public void setUsuarioDisciplina(Set<UsuarioDisciplina> usuarioDisciplina) {
		this.usuarioDisciplina = usuarioDisciplina;
	}

}
