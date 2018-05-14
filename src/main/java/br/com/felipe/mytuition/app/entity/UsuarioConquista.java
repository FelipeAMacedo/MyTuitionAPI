package br.com.felipe.mytuition.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioConquista implements Serializable {

	private static final long serialVersionUID = -6782130291264790383L;

	@EmbeddedId
	private UsuarioConquistaId id;
	
	@Column(updatable = false)
	private LocalDate dataConquista;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "id_conquista", nullable = false, insertable = false, updatable = false)
	private Conquista conquista;

	public UsuarioConquistaId getId() {
		return id;
	}

	public void setId(UsuarioConquistaId id) {
		this.id = id;
	}

	public LocalDate getDataConquista() {
		return dataConquista;
	}

	public void setDataConquista(LocalDate dataConquista) {
		this.dataConquista = dataConquista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conquista getConquista() {
		return conquista;
	}

	public void setConquista(Conquista conquista) {
		this.conquista = conquista;
	}

}
