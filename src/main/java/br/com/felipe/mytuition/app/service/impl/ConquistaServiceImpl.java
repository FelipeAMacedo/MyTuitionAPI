package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Conquista;
import br.com.felipe.mytuition.app.repository.ConquistaRepository;
import br.com.felipe.mytuition.app.service.ConquistaService;

@Service
@Transactional
public class ConquistaServiceImpl implements ConquistaService {
	private static Logger LOGGER = LoggerFactory.getLogger(ConquistaServiceImpl.class);

	@Autowired
	private ConquistaRepository repository;

	@Override
	public Conquista insert(Conquista conquista) throws Exception {
		try {
			LOGGER.info("Vai inserir uma nova conquista");
			return repository.save(conquista);
		} catch (Exception e) {
			throw new Exception("Não foi possível cadastrar o usuário", e);
		}
	}

}
