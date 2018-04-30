package br.com.felipe.mytuition.app.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipe.mytuition.app.api.UsuarioRestful;
import br.com.felipe.mytuition.app.api.dto.LoginDTO;
import br.com.felipe.mytuition.app.api.dto.UsuarioDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.LoginWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioSaveWrapper;
import br.com.felipe.mytuition.app.entity.Usuario;
import br.com.felipe.mytuition.app.service.UsuarioService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/usuario")
public class UsuarioRestfulImpl implements UsuarioRestful {

	@Autowired
	private UsuarioService service;

	private Result result = new Result();

	@Override
	@POST
	@Path("/registrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registrar(UsuarioSaveWrapper wrapper) {

		UsuarioDTO usuarioDTO = wrapper.getUsuarioDTO();

		ModelMapper mapper = new ModelMapper();
		Usuario usuario = mapper.map(usuarioDTO, Usuario.class);

		try {
			service.registrar(usuario);
			
			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Usuário inserido com sucesso");
			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	@Override
	@POST
	@Path("/logar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logar(LoginWrapper wrapper) {
		LoginDTO loginDTO = wrapper.getLoginDTO();

		ModelMapper mapper = new ModelMapper();
		Usuario usuario = mapper.map(loginDTO, Usuario.class);

		try {
			Usuario usuarioLogado = service.login(usuario);
			return Response.ok(usuarioLogado).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}

	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		UsuarioDTO usuario = new UsuarioDTO();

		usuario.setEmail("felipe");

		return Response.ok(usuario).build();
	}
}
