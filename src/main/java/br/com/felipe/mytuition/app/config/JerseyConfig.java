package br.com.felipe.mytuition.app.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.felipe.mytuition.app.api.impl.ConquistaRestfulImpl;
import br.com.felipe.mytuition.app.api.impl.DisciplinaRestfulImpl;
import br.com.felipe.mytuition.app.api.impl.HelloImpl;
import br.com.felipe.mytuition.app.api.impl.MateriaRestfulImpl;
import br.com.felipe.mytuition.app.api.impl.UsuarioRestfulImpl;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		registerEndpoints();
	}
	
	public void registerEndpoints() {
		register(HelloImpl.class);
		register(UsuarioRestfulImpl.class);
		register(DisciplinaRestfulImpl.class);
		register(MateriaRestfulImpl.class);
		register(ConquistaRestfulImpl.class);
	}
}