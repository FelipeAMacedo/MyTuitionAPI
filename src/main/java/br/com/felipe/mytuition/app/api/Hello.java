package br.com.felipe.mytuition.app.api;

import javax.ws.rs.core.Response;

public interface Hello {

	Response find(); 
	
	Response insert();
}
