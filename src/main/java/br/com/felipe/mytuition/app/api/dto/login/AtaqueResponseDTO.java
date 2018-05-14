package br.com.felipe.mytuition.app.api.dto.login;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeDeserializer;
import br.com.felipe.mytuition.app.utils.LocalDateTimeSerializer;

public class AtaqueResponseDTO implements Serializable {

	private static final long serialVersionUID = 5661921591956567863L;

	@JsonProperty("data")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime data;

	@JsonProperty("periodo")
	private Integer periodo;

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

}
