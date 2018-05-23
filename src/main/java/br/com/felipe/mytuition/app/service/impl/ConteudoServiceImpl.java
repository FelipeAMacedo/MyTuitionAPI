package br.com.felipe.mytuition.app.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Conteudo;
import br.com.felipe.mytuition.app.repository.ConteudoRepository;
import br.com.felipe.mytuition.app.service.ConteudoService;

@Service
@Transactional
public class ConteudoServiceImpl implements ConteudoService {
	private static Logger LOGGER = LoggerFactory.getLogger(ConteudoServiceImpl.class);

	@Autowired
	private ConteudoRepository repository;

	@Override
	public Set<Conteudo> findByMateriaId(Long id) throws Exception {
		LOGGER.info("Os conteúdos serão buscados");
		try {
			return repository.findByMateriaId(id);
		} catch (Exception e) {
			LOGGER.info("Erro ao buscar os conteúdos");
			throw new Exception("", e);
		}
			
	}

	@Override
	public Set<Conteudo> findQuestionsByMateriaId(Long id) throws Exception {
		LOGGER.info("As questões serão buscadas");
		try {
			return repository.findQuestionsByMateriaId(id);
		} catch (Exception e) {
			LOGGER.info("Erro ao buscar as questões");
			throw new Exception("", e);
		}
	}
	
	@Override
	public Set<Conteudo> findAvailableQuestionsByUsuarioId(String usuarioId) throws Exception {
		LOGGER.info("As questões serão buscadas");
		try {
			return repository.findAvailableQuestionsByUsuarioId(usuarioId);
		} catch (Exception e) {
			LOGGER.info("Erro ao buscar as questões");
			throw new Exception("", e);
		}
	}

}
