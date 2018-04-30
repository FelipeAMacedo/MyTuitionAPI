package br.com.felipe.mytuition.app.api.dto.conquista;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConquistaUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 7405630745140496442L;

	@JsonProperty(value = "idUsuario")
	private String idUsuario;

	@JsonProperty(value = "idConquista")
	private Long idConquista;

	@JsonProperty(value = "data")
	private LocalDate data;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdConquista() {
		return idConquista;
	}

	public void setIdConquista(Long idConquista) {
		this.idConquista = idConquista;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
