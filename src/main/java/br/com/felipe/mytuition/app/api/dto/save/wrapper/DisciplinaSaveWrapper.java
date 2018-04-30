package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.disciplina.DisciplinaDTO;

public class DisciplinaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -4920205047270404229L;

	@JsonProperty("disciplina")
	private DisciplinaDTO disciplinaDTO;

	public DisciplinaDTO getDisciplinaDTO() {
		return disciplinaDTO;
	}

	public void setDisciplinaDTO(DisciplinaDTO disciplinaDTO) {
		this.disciplinaDTO = disciplinaDTO;
	}

}
