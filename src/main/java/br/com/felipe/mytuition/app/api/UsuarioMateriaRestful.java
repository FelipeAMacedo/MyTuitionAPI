package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioMateriaSaveWrapper;

public interface UsuarioMateriaRestful {

	Response buscar(String email, Long materiaId);
	Response inserir(UsuarioMateriaSaveWrapper wrapper);
	Response atualizar(UsuarioMateriaSaveWrapper wrapper);
}
