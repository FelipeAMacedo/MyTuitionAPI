package br.com.felipe.mytuition.app.service;

import java.util.List;

import br.com.felipe.mytuition.app.entity.Conquista;

public interface ConquistaService {

	Conquista insert(Conquista conquista) throws Exception;
	
	List<Conquista> buscarNovasAtualizacoes(List<Conquista> conquistas) throws Exception;

}
