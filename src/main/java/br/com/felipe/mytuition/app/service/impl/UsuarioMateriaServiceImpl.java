package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.UsuarioMateria;
import br.com.felipe.mytuition.app.entity.UsuarioMateriaId;
import br.com.felipe.mytuition.app.repository.UsuarioMateriaRepository;
import br.com.felipe.mytuition.app.service.UsuarioMateriaService;

@Service
@Transactional
public class UsuarioMateriaServiceImpl implements UsuarioMateriaService {
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioMateriaServiceImpl.class);

	@Autowired
	private UsuarioMateriaRepository repository;

	@Override
	public UsuarioMateria inserir(UsuarioMateria usuarioMateria) throws Exception {
		if (repository.exists(usuarioMateria.getId())) {
			throw new Exception("O usuário já iniciou a matéria informada");
		}
		
		try {
			LOGGER.info("Vai atribuir uma matéria a um usuário");
			return repository.save(usuarioMateria);
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new Exception("Não foi possível atribuir uma matéria ao usuário", e);
		}
	}

	@Override
	public UsuarioMateria find(String email, Long materiaId) throws Exception {
		UsuarioMateriaId id = new UsuarioMateriaId();
		
		id.setUsuarioId(email);
		id.setMateriaId(materiaId);
		
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			throw new Exception("O usuário não iniciou a matéria informada", e);
		}

	}

	@Override
	public UsuarioMateria atualizar(UsuarioMateria usuarioMateria) throws Exception {
		if (!repository.exists(usuarioMateria.getId())) {
			throw new Exception("O usuário não iniciou a matéria informada");
		}
		
		try {
			LOGGER.info("Vai atualizar a associação de uma matéria com um usuário");
			return repository.save(usuarioMateria);
		} catch (Exception e) {
			throw new Exception("Não foi possível atualizar a associação da matéria com o usuário", e);
		}
	}

}
