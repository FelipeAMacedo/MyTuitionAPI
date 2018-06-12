package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioDisciplinaSaveWrapper;

public interface UsuarioDisciplinaRestful {

	Response buscar(String email, Long disciplinaId);
	Response inserir(UsuarioDisciplinaSaveWrapper wrapper);
	Response atualizar(UsuarioDisciplinaSaveWrapper wrapper);
}
