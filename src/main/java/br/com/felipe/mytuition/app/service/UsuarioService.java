package br.com.felipe.mytuition.app.service;

import br.com.felipe.mytuition.app.entity.Usuario;

public interface UsuarioService {

	/**
	 * Registra um novo usuário no banco de dados.
	 * 
	 * @param usuario Usuário que será registrado.
	 * @return Usuário registrado.
	 * @throws Exception
	 */
	Usuario registrar(Usuario usuario) throws Exception;

	
	/**
	 * Faz o login de um usuário.
	 * 
	 * @param usuario Usuário que irá logar.
	 * @return Usuário logado.
	 * @throws Exception
	 */
	Usuario login(Usuario usuario) throws Exception;

	
	/**
	 * Cria uma nova senha temporária para o usuário e a envia por e-mail.
	 * 
	 * @param email E-mail do usuário que terá a senha alterada.
	 * @throws Exception
	 */
	void recuperarSenha(String email) throws Exception;
}
