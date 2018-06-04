package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.curso.CursoDTO;

public class CursoSaveWrapper implements Serializable {

	private static final long serialVersionUID = -6986652387132236303L;

	@JsonProperty("curso")
	private CursoDTO cursoDTO;

	public CursoDTO getCursoDTO() {
		return cursoDTO;
	}

	public void setCursoDTO(CursoDTO cursoDTO) {
		this.cursoDTO = cursoDTO;
	}

}
