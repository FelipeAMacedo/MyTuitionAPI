package br.com.felipe.mytuition.app.api.dto.login;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroiResponseDTO implements Serializable {

	private static final long serialVersionUID = 8121810391676220L;

	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "imagem")
	private String imagem;

	@JsonProperty(value = "xp")
	private Integer xp;

	@JsonProperty(value = "forca")
	private Integer forca;

	@JsonProperty(value = "agilidade")
	private Integer agilidade;

	@JsonProperty(value = "defesa")
	private Integer defesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public Integer getForca() {
		return forca;
	}

	public void setForca(Integer forca) {
		this.forca = forca;
	}

	public Integer getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(Integer agilidade) {
		this.agilidade = agilidade;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

}
