package br.com.felipe.mytuition.app.api.dto.save.wrapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.heroi.AtualizacaoExperienciaDTO;

public class AtualizacaoExperienciaWrapper implements Serializable {

	private static final long serialVersionUID = 29172965326690849L;

	@JsonProperty(value = "heroi")
	private AtualizacaoExperienciaDTO atualizacaoExperienciaDTO;

	public AtualizacaoExperienciaDTO getAtualizacaoExperienciaDTO() {
		return atualizacaoExperienciaDTO;
	}

	public void setAtualizacaoExperienciaDTO(AtualizacaoExperienciaDTO atualizacaoExperienciaDTO) {
		this.atualizacaoExperienciaDTO = atualizacaoExperienciaDTO;
	}

}
