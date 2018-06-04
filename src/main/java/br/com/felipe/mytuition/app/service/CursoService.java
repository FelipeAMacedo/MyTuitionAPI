package br.com.felipe.mytuition.app.service;

import java.util.List;

import br.com.felipe.mytuition.app.entity.Curso;

public interface CursoService {

	Curso inserir(Curso curso) throws Exception;
	List<Curso> buscarTodos() throws Exception;
}
