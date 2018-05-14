package br.com.felipe.mytuition.app.service;

import br.com.felipe.mytuition.app.entity.Heroi;

public interface HeroiService {
 
	Heroi adicionarExperiencia(Long id, Integer pontos) throws Exception;
}
