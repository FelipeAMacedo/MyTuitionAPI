package br.com.felipe.mytuition.app.service;

import br.com.felipe.mytuition.app.entity.UsuarioDisciplina;

public interface UsuarioDisciplinaService {
	
	UsuarioDisciplina inserir(UsuarioDisciplina usuarioDisciplina) throws Exception;

	UsuarioDisciplina find(String email, Long disciplinaId) throws Exception;
	
	UsuarioDisciplina atualizar(UsuarioDisciplina usuarioDisciplina) throws Exception;

}
