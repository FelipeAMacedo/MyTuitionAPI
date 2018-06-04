package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.CursoSaveWrapper;

public interface CursoRestful {

	Response insert(CursoSaveWrapper wrapper);
	Response findAll();
}
