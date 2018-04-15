package app.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import app.api.UsuarioRestful;
import app.api.dto.UsuarioDTO;
import app.api.dto.wrapper.UsuarioSaveWrapper;
import app.utils.Result;
import entity.Usuario;
import service.UsuarioService;

@Path("/usuario")
public class UsuarioRestfulImpl implements UsuarioRestful {
	
	@Autowired
	private UsuarioService service;
	
	private Result result = new Result();

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(UsuarioSaveWrapper wrapper) {
		
		UsuarioDTO usuarioDTO = wrapper.getUsuarioDTO();
		
		ModelMapper mapper = new ModelMapper();
		Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
		
		try {
			service.registrar(usuario);
			return Response.ok().build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());
			
			return Response.status(result.getCode()).entity(result).build();
		}
	}
}
