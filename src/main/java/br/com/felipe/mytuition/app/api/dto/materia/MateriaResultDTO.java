package br.com.felipe.mytuition.app.api.dto.materia;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.api.dto.usuarioMateria.UsuarioMateriaResultDTO;
import br.com.felipe.mytuition.app.enumerations.Atributo;

public class MateriaResultDTO implements Serializable {

	private static final long serialVersionUID = -8729032093983945789L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "pontos")
	private Integer pontos;

	@JsonProperty(value = "atributo")
	private Atributo atributo;

	@JsonProperty(value = "usuarioMateria")
	private Set<UsuarioMateriaResultDTO> usuarioMateriaResultDTO;

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

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

	public Set<UsuarioMateriaResultDTO> getUsuarioMateriaResultDTO() {
		return usuarioMateriaResultDTO;
	}

	public void setUsuarioMateriaResultDTO(Set<UsuarioMateriaResultDTO> usuarioMateriaResultDTO) {
		this.usuarioMateriaResultDTO = usuarioMateriaResultDTO;
	}

}
