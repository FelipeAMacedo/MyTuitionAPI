package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.DisciplinaSaveWrapper;

public interface DisciplinaRestful {

	Response insert(DisciplinaSaveWrapper wrapper);
	Response findAll();
}
