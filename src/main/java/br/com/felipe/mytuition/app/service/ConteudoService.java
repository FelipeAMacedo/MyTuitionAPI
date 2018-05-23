package br.com.felipe.mytuition.app.service;

import java.util.Set;

import br.com.felipe.mytuition.app.entity.Conteudo;

public interface ConteudoService {

	Set<Conteudo> findByMateriaId(Long id) throws Exception;

	Set<Conteudo> findQuestionsByMateriaId(Long id) throws Exception;
	
	Set<Conteudo> findAvailableQuestionsByUsuarioId(String usuarioId) throws Exception;
}
