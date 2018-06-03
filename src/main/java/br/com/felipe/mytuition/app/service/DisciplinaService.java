package br.com.felipe.mytuition.app.service;

import java.util.List;

import br.com.felipe.mytuition.app.entity.Disciplina;

public interface DisciplinaService {

	Disciplina inserir(Disciplina disciplina) throws Exception;
	List<Disciplina> buscarTodas(String email) throws Exception;
}
