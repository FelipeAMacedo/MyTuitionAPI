package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.AtualizacaoExperienciaWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.AumentarPontosWrapper;

public interface HeroiRestful {

	Response adicionarExperiencia(AtualizacaoExperienciaWrapper wrapper);
	Response aumentarPontos(AumentarPontosWrapper wrapper);
}
