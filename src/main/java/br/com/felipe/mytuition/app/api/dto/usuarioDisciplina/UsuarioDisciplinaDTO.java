package br.com.felipe.mytuition.app.api.dto.usuarioDisciplina;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeDeserializer;

public class UsuarioDisciplinaDTO implements Serializable {
	
	private static final long serialVersionUID = 3418512815382660990L;

	@JsonProperty(value = "usuario")
    private UsuarioDisciplinaUsuarioDTO usuario;

    @JsonProperty(value = "disciplina")
    private UsuarioDisciplinaDisciplinaDTO disciplina;

    @JsonProperty(value = "inicio")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime inicio;

    @JsonProperty(value = "conclusao")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime conclusao;

    public UsuarioDisciplinaUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDisciplinaUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDisciplinaDisciplinaDTO getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(UsuarioDisciplinaDisciplinaDTO disciplina) {
        this.disciplina = disciplina;
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
