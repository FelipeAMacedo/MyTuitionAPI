package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Disciplina;
import br.com.felipe.mytuition.app.repository.DisciplinaRepository;
import br.com.felipe.mytuition.app.service.DisciplinaService;

@Service
@Transactional
public class DisciplinaServiceImpl implements DisciplinaService {
	private static Logger LOGGER = LoggerFactory.getLogger(DisciplinaServiceImpl.class);

	@Autowired
	private DisciplinaRepository repository;

	@Override
	public Disciplina inserir(Disciplina disciplina) throws Exception {
		LOGGER.info("Vai inserir uma nova matéria");
		try {
			return repository.save(disciplina);
		} catch (Exception e) {
			LOGGER.info("Não foi possível inserir uma nova materia");
			throw new Exception("Não foi possível inserir a matéria", e);
		}
	}

}
