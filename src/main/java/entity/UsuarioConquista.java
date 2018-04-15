package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsuarioConquista implements Serializable {

	private static final long serialVersionUID = -6782130291264790383L;

	@EmbeddedId
	private UsuarioConquistaId id;

	@Temporal(TemporalType.DATE)
	private LocalDate dataConquista;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Set<Usuario> usuario = new HashSet<>(0);

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conquista", nullable = false, insertable = false, updatable = false)
	private Set<Conquista> conquista = new HashSet<>(0);

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

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Set<Conquista> getConquista() {
		return conquista;
	}

	public void setConquista(Set<Conquista> conquista) {
		this.conquista = conquista;
	}

}
