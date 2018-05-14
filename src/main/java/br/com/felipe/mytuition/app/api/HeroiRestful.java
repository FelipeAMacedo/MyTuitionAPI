package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.AtualizacaoExperienciaWrapper;

public interface HeroiRestful {

	Response adicionarExperiencia(AtualizacaoExperienciaWrapper wrapper);
}
