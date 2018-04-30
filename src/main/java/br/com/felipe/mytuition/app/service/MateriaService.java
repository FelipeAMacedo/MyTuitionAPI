package br.com.felipe.mytuition.app.service;

import java.util.List;

import br.com.felipe.mytuition.app.entity.Materia;

public interface MateriaService {

	Materia inserir(Materia materia) throws Exception;

	List<Materia> findByDisciplinaId(Long id) throws Exception;
}
