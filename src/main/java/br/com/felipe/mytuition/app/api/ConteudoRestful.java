package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

public interface ConteudoRestful {

	Response findByMateria(Long id);
	Response findQuestionsByMateria(Long id);
}
