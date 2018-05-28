package br.com.felipe.mytuition.app.api.dto.conquista;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeDeserializer;

public class ConquistaSaveDTO implements Serializable {

	private static final long serialVersionUID = 7405630745140496442L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "descricao")
	private String descricao;

	@JsonProperty(value = "imagem")
	private String imagem;

	@JsonProperty(value = "dataCriacao")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataCriacao;

	@JsonProperty(value = "dataAlteracao")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataAlteracao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
