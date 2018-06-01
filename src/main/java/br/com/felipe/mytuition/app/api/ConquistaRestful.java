package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaBuscaWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaUsuarioSaveWrapper;

public interface ConquistaRestful {

	Response conquistar(ConquistaUsuarioSaveWrapper wrapper);
	Response insert(ConquistaSaveWrapper wrapper);
	Response buscarNovasAtualizacoes(ConquistaBuscaWrapper wrapper, String email);
	Response findAll();
}
