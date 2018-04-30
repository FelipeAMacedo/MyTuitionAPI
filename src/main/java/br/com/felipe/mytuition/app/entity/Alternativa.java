package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alternativa implements Serializable {

	private static final long serialVersionUID = -7533376860509933663L;

	@Id
	@GeneratedValue
	private Long id;

	private Integer ordem;
	private String texto;
	private Boolean certo;

	@ManyToOne
	private Conteudo conteudo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Boolean getCerto() {
		return certo;
	}

	public void setCerto(Boolean certo) {
		this.certo = certo;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

}
