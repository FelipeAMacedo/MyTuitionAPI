package br.com.felipe.mytuition.app.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.mytuition.app.entity.Usuario;
import br.com.felipe.mytuition.app.repository.UsuarioRepository;
import br.com.felipe.mytuition.app.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario registrar(Usuario usuario) throws Exception {
		if (repository.existsByEmail(usuario.getEmail())) {
			LOGGER.info("Verificação de existência de usuário");
			throw new Exception("Já existe um usuário cadastrado com este e-mail");
		}

		try {
			LOGGER.info("Vai inserir um novo usuário");
			return repository.save(usuario);
		} catch (Exception e) {
			throw new Exception("Não foi possível cadastrar o usuário", e);
		}
	}

	@Override
	public Usuario login(Usuario usuario) throws Exception {
		
		Usuario usuarioLogado = null;
		
		try {
			LOGGER.info("Vai logar");
			usuarioLogado = repository.login(usuario.getEmail(), usuario.getSenha());
		} catch (Exception e) {
			throw new Exception("Não foi possível logar", e);
		}

		if (usuarioLogado != null) {
			LOGGER.info("Login efetuado com sucesso");
			return usuarioLogado;
		} else {
			LOGGER.info("E-mail e/ou senha incorretos");
			throw new Exception("E-mail e/ou senha incorretos");
		}
	}

}
