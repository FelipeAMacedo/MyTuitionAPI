package br.com.felipe.mytuition.app.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.felipe.mytuition.app.api.UsuarioDisciplinaRestful;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioDisciplinaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.usuarioDisciplina.UsuarioDisciplinaDTO;
import br.com.felipe.mytuition.app.api.dto.usuarioDisciplina.UsuarioDisciplinaResultDTO;
import br.com.felipe.mytuition.app.entity.UsuarioDisciplina;
import br.com.felipe.mytuition.app.entity.UsuarioDisciplinaId;
import br.com.felipe.mytuition.app.service.UsuarioDisciplinaService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/usuarioDisciplina")
public class UsuarioDisciplinaRestfulImpl implements UsuarioDisciplinaRestful {

	@Autowired
	private UsuarioDisciplinaService service;

	private Result result = new Result();

	@Override
	@POST
	@Path("/iniciar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(UsuarioDisciplinaSaveWrapper wrapper) {

		UsuarioDisciplina usuarioDisciplina = mapDTOToEntity(wrapper.getUsuarioDisciplinaDTO());

		try {
			service.inserir(usuarioDisciplina);

			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Usuário associado à disciplina com sucesso");
			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private UsuarioDisciplina mapDTOToEntity(UsuarioDisciplinaDTO usuarioDisciplinaDTO) {
		ModelMapper modelMapper = new ModelMapper();
		UsuarioDisciplina usuarioDisciplina = modelMapper.map(usuarioDisciplinaDTO, UsuarioDisciplina.class);

		UsuarioDisciplinaId id = new UsuarioDisciplinaId();
		id.setDisciplinaId(usuarioDisciplinaDTO.getDisciplina().getId());
		id.setUsuarioId(usuarioDisciplinaDTO.getUsuario().getEmail());

		usuarioDisciplina.setId(id);

		return usuarioDisciplina;
	}

	@Override
	@GET
	@Path("/{email}/{disciplinaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("email") String email, @PathParam("disciplinaId") Long disciplinaId) {
		UsuarioDisciplina usuarioDisciplina;

		try {
			usuarioDisciplina = service.find(email, disciplinaId);

			if (usuarioDisciplina == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("O usuário não iniciou o estudo da disciplina");

				return Response.status(result.getCode()).entity(result).build();
			}

			UsuarioDisciplinaResultDTO usuarioDisciplinaDTO = new ModelMapper().map(usuarioDisciplina,
					UsuarioDisciplinaResultDTO.class);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("usuarioDisciplina");
			String responseList = writer.writeValueAsString(usuarioDisciplinaDTO);

			return Response.ok(responseList).build();

		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	@Override
	@PUT
	@Path("/finalizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(UsuarioDisciplinaSaveWrapper wrapper) {

		UsuarioDisciplina usuarioDisciplina = mapDTOToEntity(wrapper.getUsuarioDisciplinaDTO());

		try {
			service.atualizar(usuarioDisciplina);

			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Associação entre usuário e disciplina atualizada com sucesso");
			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
}
