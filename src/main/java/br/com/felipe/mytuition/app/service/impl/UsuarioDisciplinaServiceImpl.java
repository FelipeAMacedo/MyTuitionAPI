package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.UsuarioDisciplina;
import br.com.felipe.mytuition.app.entity.UsuarioDisciplinaId;
import br.com.felipe.mytuition.app.repository.UsuarioDisciplinaRepository;
import br.com.felipe.mytuition.app.service.UsuarioDisciplinaService;

@Service
@Transactional
public class UsuarioDisciplinaServiceImpl implements UsuarioDisciplinaService {
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioDisciplinaServiceImpl.class);

	@Autowired
	private UsuarioDisciplinaRepository repository;

	@Override
	public UsuarioDisciplina inserir(UsuarioDisciplina usuarioDisciplina) throws Exception {
		if (repository.exists(usuarioDisciplina.getId())) {
			throw new Exception("O usuário já iniciou a disciplina informada");
		}
		
		try {
			LOGGER.info("Vai atribuir uma disciplina a um usuário");
			return repository.save(usuarioDisciplina);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new Exception("Não foi possível atribuir uma disciplina ao usuário", e);
		}
	}

	@Override
	public UsuarioDisciplina find(String email, Long disciplinaId) throws Exception {
		UsuarioDisciplinaId id = new UsuarioDisciplinaId();
		
		id.setUsuarioId(email);
		id.setDisciplinaId(disciplinaId);
		
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new Exception("O usuário não iniciou a disciplina informada", e);
		}

	}

	@Override
	public UsuarioDisciplina atualizar(UsuarioDisciplina usuarioDisciplina) throws Exception {
		if (!repository.exists(usuarioDisciplina.getId())) {
			throw new Exception("O usuário não iniciou a disciplina informada");
		}
		
		try {
			LOGGER.info("Vai atualizar a associação de uma disciplina com um usuário");
			return repository.save(usuarioDisciplina);
		} catch (Exception e) {
			throw new Exception("Não foi possível atualizar a associação da disciplina com o usuário", e);
		}
	}

}
