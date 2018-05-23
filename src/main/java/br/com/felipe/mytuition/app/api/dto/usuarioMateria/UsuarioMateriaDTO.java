package br.com.felipe.mytuition.app.api.dto.usuarioMateria;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.felipe.mytuition.app.utils.LocalDateTimeDeserializer;

public class UsuarioMateriaDTO implements Serializable {
	
	private static final long serialVersionUID = -1676861532803647247L;

	@JsonProperty(value = "usuario")
    private UsuarioMateriaUsuarioDTO usuario;

    @JsonProperty(value = "materia")
    private UsuarioMateriaMateriaDTO materia;

    @JsonProperty(value = "inicio")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime inicio;

    @JsonProperty(value = "conclusao")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime conclusao;

    public UsuarioMateriaUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMateriaUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioMateriaMateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(UsuarioMateriaMateriaDTO materia) {
        this.materia = materia;
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
