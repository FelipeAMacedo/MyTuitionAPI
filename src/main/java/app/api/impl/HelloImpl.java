package app.api.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import app.api.Hello;
import app.api.HelloDTO;

@Component
@Path("/")
public class HelloImpl implements Hello {

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response find() {
		HelloDTO dto = new HelloDTO();
		dto.setNome("Josi");
		
		return Response.ok(dto).build();
	}

}
