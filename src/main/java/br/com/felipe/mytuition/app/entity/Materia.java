package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.felipe.mytuition.app.enumerations.Atributo;

@Entity
public class Materia implements Serializable {

	private static final long serialVersionUID = 6005322491077995346L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private Integer pontos;

	@Enumerated
	private Atributo atributo;

	@ManyToOne(optional = false)
	private Disciplina disciplina;

	@OneToMany(mappedBy = "materia", cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	private Set<Conteudo> conteudo = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "materia", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UsuarioMateria> usuarioMateria = new HashSet<>(0);
	
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

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Conteudo> getConteudo() {
		return conteudo;
	}

	public void setConteudo(Set<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}

	public Set<UsuarioMateria> getUsuarioMateria() {
		return usuarioMateria;
	}

	public void setUsuarioMateria(Set<UsuarioMateria> usuarioMateria) {
		this.usuarioMateria = usuarioMateria;
	}

}
