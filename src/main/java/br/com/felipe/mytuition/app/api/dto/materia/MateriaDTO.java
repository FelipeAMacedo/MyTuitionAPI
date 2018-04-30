package br.com.felipe.mytuition.app.api.dto.materia;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.felipe.mytuition.app.enumerations.Atributo;

public class MateriaDTO implements Serializable {

	private static final long serialVersionUID = 4581686743290460035L;

	@JsonProperty(value = "nome")
	private String nome;

	@JsonProperty(value = "pontos")
	private Integer pontos;

	@JsonProperty(value = "disciplina")
	private DisciplinaDTO disciplina;

	@JsonProperty(value = "conteudo")
	private Set<ConteudoDTO> conteudo;

	@JsonProperty(value = "atributo")
	private Atributo atributo;

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

	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	public Set<ConteudoDTO> getConteudo() {
		return conteudo;
	}

	public void setConteudo(Set<ConteudoDTO> conteudo) {
		this.conteudo = conteudo;
	}

	public Atributo getAtributo() {
		return atributo;
	}

	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}

}
