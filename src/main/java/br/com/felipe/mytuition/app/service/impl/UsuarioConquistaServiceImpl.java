package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.UsuarioConquista;
import br.com.felipe.mytuition.app.repository.UsuarioConquistaRepository;
import br.com.felipe.mytuition.app.service.UsuarioConquistaService;

@Service
@Transactional
public class UsuarioConquistaServiceImpl implements UsuarioConquistaService {
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioConquistaServiceImpl.class);

	@Autowired
	private UsuarioConquistaRepository repository;

	@Override
	public UsuarioConquista inserir(UsuarioConquista usuarioConquista) throws Exception {
		try {
			LOGGER.info("Vai atribuir uma nova conquista a um usuário");
			return repository.save(usuarioConquista);
		} catch (Exception e) {
			throw new Exception("Não foi possível atribuir uma nova conquista ao usuário", e);
		}
	}

}
