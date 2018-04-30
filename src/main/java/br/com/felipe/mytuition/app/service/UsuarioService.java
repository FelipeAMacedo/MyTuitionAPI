package br.com.felipe.mytuition.app.service;

import br.com.felipe.mytuition.app.entity.Usuario;

public interface UsuarioService {

	Usuario registrar(Usuario usuario) throws Exception;

	Usuario login(Usuario usuario) throws Exception;
}
