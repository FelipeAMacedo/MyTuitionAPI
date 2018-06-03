package br.com.felipe.mytuition.app.api.dto.disciplina;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.usuarioDisciplina.UsuarioDisciplinaResultDTO;

public class DisciplinaResultDTO implements Serializable {

	private static final long serialVersionUID = -3591028808512872446L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "descricao")
	private String descricao;

	@JsonProperty(value = "usuarioDisciplina")
	private Set<UsuarioDisciplinaResultDTO> usuarioDisciplinaResultDTO;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<UsuarioDisciplinaResultDTO> getUsuarioDisciplinaResultDTO() {
		return usuarioDisciplinaResultDTO;
	}

	public void setUsuarioDisciplinaResultDTO(Set<UsuarioDisciplinaResultDTO> usuarioDisciplinaResultDTO) {
		this.usuarioDisciplinaResultDTO = usuarioDisciplinaResultDTO;
	}

}
