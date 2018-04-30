package br.com.felipe.mytuition.app.api.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import br.com.felipe.mytuition.app.api.Hello;
import br.com.felipe.mytuition.app.api.HelloDTO;

@Component
@Path("/hellooodjasjdpaosd/asdasd")
public class HelloImpl implements Hello {

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response find() {
		HelloDTO dto = new HelloDTO();
		dto.setNome("Pinho");
		System.out.println("O GET FOI EXECUTADO");
		return Response.ok(dto).build();
	}
	
	@Override
	@POST
	public Response insert() {
		
		System.out.println("Foi tentado o insert");
		
		return Response.ok().build();
	}

}
