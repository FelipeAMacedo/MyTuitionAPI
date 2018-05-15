package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ataque implements Serializable {

	private static final long serialVersionUID = -8349172176229666728L;

	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDateTime data;

	private Integer periodo;
	
	private Boolean venceu;
	
	private Integer pontos;

	@ManyToOne
	private Usuario usuario;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "ataque", orphanRemoval = true)
	private Set<Conteudo> conteudo = new HashSet<>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Boolean getVenceu() {
		return venceu;
	}

	public void setVenceu(Boolean venceu) {
		this.venceu = venceu;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Conteudo> getConteudo() {
		return conteudo;
	}

	public void setConteudo(Set<Conteudo> conteudo) {
		this.conteudo = conteudo;
	}

}
