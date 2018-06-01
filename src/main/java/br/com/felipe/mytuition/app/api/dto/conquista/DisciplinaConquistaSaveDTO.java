package br.com.felipe.mytuition.app.api.dto.conquista;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaConquistaSaveDTO implements Serializable {

	private static final long serialVersionUID = -4536885615934830525L;

	@JsonProperty(value = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
