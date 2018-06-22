package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

import br.com.felipe.mytuition.app.api.dto.save.wrapper.LoginWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioSaveWrapper;

public interface UsuarioRestful {

	Response registrar(UsuarioSaveWrapper wrapper);
	Response logar(LoginWrapper wrapper);
	
	Response findAll();
	
	Response recuperarSenha(String email);
}
