package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.MateriaSaveWrapper;

public interface MateriaRestful {

	Response insert(MateriaSaveWrapper wrapper);
	Response findAll();
	Response findByDisciplina(Long id);
}
