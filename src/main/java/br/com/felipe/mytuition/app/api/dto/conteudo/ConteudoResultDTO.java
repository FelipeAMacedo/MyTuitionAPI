package br.com.felipe.mytuition.app.api.dto.conteudo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalTimeDeserializer;
import br.com.felipe.mytuition.app.utils.LocalTimeSerializer;

public class ConteudoResultDTO implements Serializable {

	private static final long serialVersionUID = -6888810032548854299L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "ordem")
	private Integer ordem;

	@JsonProperty(value = "texto")
	private String texto;

	@JsonProperty(value = "duracao")
	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@JsonSerialize(using = LocalTimeSerializer.class)
	private LocalTime duracao;

	@JsonProperty(value = "alternativas")
	private Set<AlternativasResultDTO> alternativas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public Set<AlternativasResultDTO> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Set<AlternativasResultDTO> alternativas) {
		this.alternativas = alternativas;
	}

}
