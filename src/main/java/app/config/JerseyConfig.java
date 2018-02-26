package app.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import app.api.impl.HelloImpl;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		registerEndpoints();
	}
	
	public void registerEndpoints() {
		register(HelloImpl.class);
	}
}
