package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.materia.MateriaDTO;

public class MateriaSaveWrapper implements Serializable {

	private static final long serialVersionUID = -2434862339757379671L;

	@JsonProperty(value = "materia")
	private MateriaDTO materiaDTO;

	public MateriaDTO getMateriaDTO() {
		return materiaDTO;
	}

	public void setMateriaDTO(MateriaDTO materiaDTO) {
		this.materiaDTO = materiaDTO;
	}
	
	
}
