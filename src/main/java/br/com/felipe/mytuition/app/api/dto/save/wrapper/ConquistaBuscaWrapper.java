package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaBuscaDTO;

public class ConquistaBuscaWrapper implements Serializable {

	private static final long serialVersionUID = -4920205047270404229L;

	@JsonProperty("conquistas")
	private List<ConquistaBuscaDTO> conquistaBuscaDTO;

	public List<ConquistaBuscaDTO> getConquistaBuscaDTO() {
		return conquistaBuscaDTO;
	}

	public void setConquistaBuscaDTO(List<ConquistaBuscaDTO> conquistaBuscaDTO) {
		this.conquistaBuscaDTO = conquistaBuscaDTO;
	}
}
