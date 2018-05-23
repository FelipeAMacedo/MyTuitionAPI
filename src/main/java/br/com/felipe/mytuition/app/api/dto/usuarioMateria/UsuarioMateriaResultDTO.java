package br.com.felipe.mytuition.app.api.dto.usuarioMateria;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeSerializer;

public class UsuarioMateriaResultDTO implements Serializable {

	private static final long serialVersionUID = 2664561709725718337L;

	@JsonProperty(value = "materia")
	private UsuarioMateriaMateriaDTO materia;

	@JsonProperty(value = "usuario")
	private UsuarioMateriaUsuarioDTO usuario;

	@JsonProperty(value = "inicio")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime inicio;

	@JsonProperty(value = "conclusao")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime conclusao;

	public UsuarioMateriaMateriaDTO getMateria() {
		return materia;
	}

	public void setMateria(UsuarioMateriaMateriaDTO materia) {
		this.materia = materia;
	}

	public UsuarioMateriaUsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioMateriaUsuarioDTO usuario) {
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
