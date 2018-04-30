package br.com.felipe.mytuition.app.api.dto.materia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisciplinaDTO implements Serializable {

	private static final long serialVersionUID = 6563243374801542354L;

	@JsonProperty(value = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
