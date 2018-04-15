package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Usuario;
import repository.UsuarioRepository;
import service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	@Override
	public Usuario registrar(Usuario usuario) throws Exception {
		if (repository.existsByEmail(usuario.getEmail())) {
			throw new Exception("Já existe um usuário cadastrado com este e-mail");
		}
		
		try {
			return repository.save(usuario);
		} catch (Exception e) {
			throw new Exception("Não foi possível cadastrar o usuário");
		}
	}

}
