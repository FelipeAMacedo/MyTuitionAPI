package br.com.felipe.mytuition.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Materia;
import br.com.felipe.mytuition.app.repository.MateriaRepository;
import br.com.felipe.mytuition.app.service.MateriaService;

@Service
@Transactional
public class MateriaServiceImpl implements MateriaService {
	private static Logger LOGGER = LoggerFactory.getLogger(MateriaServiceImpl.class);

	@Autowired
	private MateriaRepository repository;

	@Override
	public Materia inserir(Materia materia) throws Exception {
		LOGGER.info("Vai inserir uma nova matéria");
		try {
			return repository.save(materia);
		} catch (Exception e) {
			LOGGER.info("Não foi possível inserir uma nova materia");
			throw new Exception("Não foi possível inserir a matéria", e);
		}
	}

	@Override
	public List<Materia> findByDisciplinaId(Long id) throws Exception {
		LOGGER.info("As matérias serão buscadas");
		try {
			return repository.findByDisciplinaId(id);
		} catch (Exception e) {
			LOGGER.info("Erro ao buscar as matérias");
			throw new Exception("", e);
		}
			
	}

}
