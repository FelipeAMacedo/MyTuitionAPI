package br.com.felipe.mytuition.app.api.dto.conquista;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeDeserializer;

public class ConquistaBuscaDTO implements Serializable {

	private static final long serialVersionUID = 7605899695324199558L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "dataAlteracao")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataAlteracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
