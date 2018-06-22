package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Heroi;
import br.com.felipe.mytuition.app.repository.HeroiRepository;
import br.com.felipe.mytuition.app.service.HeroiService;

@Service
@Transactional
public class HeroiServiceImpl implements HeroiService {
	private static Logger LOGGER = LoggerFactory.getLogger(HeroiServiceImpl.class);

	@Autowired
	private HeroiRepository repository;

	@Override
	public Heroi adicionarExperiencia(Long id, Integer pontos) throws Exception {
		LOGGER.info("Será adicionada experiência ao herói");
		
		Heroi heroi = repository.findOne(id);
		if (heroi == null) {
			throw new Exception("O herói com o id " + id + " não existe");
		}
		
		heroi.setXp(heroi.getXp() + pontos);
		
		return repository.save(heroi);
	}

	@Override
	public Heroi aumentarPontos(Heroi heroi) throws Exception {
		LOGGER.info("Será adicionado pontos ao herói");
		
		Heroi heroiFromDb = repository.findOne(heroi.getId());
		if (heroiFromDb == null) {
			throw new Exception("O herói com o id " + heroi.getId() + " não existe");
		}
		
		heroiFromDb.setAtaque(heroi.getAtaque());
		heroiFromDb.setDefesa(heroi.getDefesa());
		
		return repository.save(heroiFromDb);
	}

}
