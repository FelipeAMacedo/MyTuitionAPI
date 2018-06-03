package br.com.felipe.mytuition.app.api.dto.usuarioDisciplina;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeSerializer;

public class UsuarioDisciplinaResultDTO implements Serializable {

	private static final long serialVersionUID = -6933085875367008170L;

	@JsonProperty(value = "disciplina")
	private UsuarioDisciplinaDisciplinaDTO disciplina;

	@JsonProperty(value = "usuario")
	private UsuarioDisciplinaUsuarioDTO usuario;

	@JsonProperty(value = "inicio")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime inicio;

	@JsonProperty(value = "conclusao")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime conclusao;

	public UsuarioDisciplinaDisciplinaDTO getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(UsuarioDisciplinaDisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}

	public UsuarioDisciplinaUsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDisciplinaUsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getConclusao() {
		return conclusao;
	}

	public void setConclusao(LocalDateTime conclusao) {
		this.conclusao = conclusao;
	}

}
