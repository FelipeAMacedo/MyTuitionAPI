package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Conteudo implements Serializable {

	private static final long serialVersionUID = -6216301285326219806L;

	@Id
	@GeneratedValue
	private Long id;

	private String texto;
	private LocalTime duracao;

	private Integer ordem;

	@ManyToOne
	private Materia materia;

	@ManyToOne
	private Ataque ataque;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "conteudo", orphanRemoval = true )
	private Set<Alternativa> alternativas = new HashSet<>(0);

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "conteudo", orphanRemoval = true)
	private Set<UsuarioConteudo> usuarioConteudo = new HashSet<>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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
	
	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Set<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Set<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Set<UsuarioConteudo> getUsuarioConteudo() {
		return usuarioConteudo;
	}

	public void setUsuarioConteudo(Set<UsuarioConteudo> usuarioConteudo) {
		this.usuarioConteudo = usuarioConteudo;
	}

}
