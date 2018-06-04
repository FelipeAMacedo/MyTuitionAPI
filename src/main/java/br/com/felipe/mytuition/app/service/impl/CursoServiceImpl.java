package br.com.felipe.mytuition.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Curso;
import br.com.felipe.mytuition.app.repository.CursoRepository;
import br.com.felipe.mytuition.app.service.CursoService;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {
	private static Logger LOGGER = LoggerFactory.getLogger(CursoServiceImpl.class);

	@Autowired
	private CursoRepository repository;

	@Override
	public Curso inserir(Curso curso) throws Exception {
		LOGGER.info("Vai inserir um novo curso");
		try {
			return repository.save(curso);
		} catch (Exception e) {
			LOGGER.info("Não foi possível inserir uma nova materia");
			throw new Exception("Não foi possível inserir a matéria", e);
		}
	}

	@Override
	public List<Curso> buscarTodos() throws Exception {
		LOGGER.info("Os cursos serão buscadas");
		try {
			return repository.findAll();
		} catch (Exception e) {
			LOGGER.info("Erro ao buscar os cursos");
			throw new Exception("Erro ao buscar os cursos", e);
		}

	}

}
