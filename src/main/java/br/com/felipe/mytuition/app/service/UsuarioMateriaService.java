package br.com.felipe.mytuition.app.service;

import br.com.felipe.mytuition.app.entity.UsuarioMateria;

public interface UsuarioMateriaService {
	
	UsuarioMateria inserir(UsuarioMateria usuarioMateria) throws Exception;

	UsuarioMateria find(String email, Long materiaId) throws Exception;
	
	UsuarioMateria atualizar(UsuarioMateria usuarioMateria) throws Exception;

}
