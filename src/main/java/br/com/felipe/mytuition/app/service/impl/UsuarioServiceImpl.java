package br.com.felipe.mytuition.app.service.impl;

import java.util.Properties;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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

	
	@Override
	public void recuperarSenha(String email) throws Exception {
		Usuario usuario = repository.findOne(email);

		if (usuario == null) {
			throw new Exception("O usuário informado não existe");
		}

		usuario.setSenha(UUID.randomUUID().toString().substring(0, 5));

		try {
			repository.save(usuario);

			try {
				enviarEmail(email, usuario.getSenha());
				LOGGER.info("E-mail enviado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.info("Erro ao enviar o e-mail");
				throw new Exception("Erro ao enviar o e-mail", e);
			}
		} catch (Exception e) {
			LOGGER.info("Erro ao atualizar a senha do usuario");
			throw new Exception("Não foi possível trocar a senha do usuário", e);
		}
	}

	/**
	 * Envia o e-mail com a nova senha gerada.
	 * 
	 * @param email Endereço de e-mail do destinatário.
	 * @param novaSenha Nova senha gerada.
	 */
	private void enviarEmail(String email, String novaSenha) {
		LOGGER.info("Configurando o e-mail...");
		JavaMailSenderImpl mailSender = configurarEmail();

		LOGGER.info("Enviando o e-mail...");
		mailSender.send(montarMensagem(email, novaSenha));
	}
	
	/**
	 * Monta a mensagem com a nova senha gerada.
	 * 
	 * @param email Endereço de e-mail do destinatário.
	 * @param novaSenha Nova senha gerada.
	 * @return Mensagem montada.
	 */
	private SimpleMailMessage montarMensagem(String email, String novaSenha) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(email);
		message.setFrom("felipexalves@gmail.com");
		message.setText("A sua senha foi alterada para " + novaSenha);
		message.setSubject("Alteração de senha");
		
		return message;
	}

	/**
	 * Realiza a configuração do JavaMailSender para o envio do e-mail.
	 * 
	 * @return JavaMailSender configurado.
	 */
	private JavaMailSenderImpl configurarEmail() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("felipexalves@gmail.com");
		mailSender.setPassword("Fa16171608!");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "false");

		return mailSender;
	}

}
