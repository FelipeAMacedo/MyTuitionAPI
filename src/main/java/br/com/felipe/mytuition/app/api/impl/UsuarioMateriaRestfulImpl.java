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

import br.com.felipe.mytuition.app.api.UsuarioMateriaRestful;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.UsuarioMateriaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.usuarioMateria.UsuarioMateriaDTO;
import br.com.felipe.mytuition.app.api.dto.usuarioMateria.UsuarioMateriaResultDTO;
import br.com.felipe.mytuition.app.entity.UsuarioMateria;
import br.com.felipe.mytuition.app.entity.UsuarioMateriaId;
import br.com.felipe.mytuition.app.service.UsuarioMateriaService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/usuarioMateria")
public class UsuarioMateriaRestfulImpl implements UsuarioMateriaRestful {

	@Autowired
	private UsuarioMateriaService service;

	private Result result = new Result();

	@Override
	@POST
	@Path("/iniciar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(UsuarioMateriaSaveWrapper wrapper) {

		UsuarioMateria usuarioMateria = mapDTOToEntity(wrapper.getUsuarioMateriaDTO());

		try {
			service.inserir(usuarioMateria);

			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Usuário associado à matéria com sucesso");
			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private UsuarioMateria mapDTOToEntity(UsuarioMateriaDTO usuarioMateriaDTO) {
		ModelMapper modelMapper = new ModelMapper();
		UsuarioMateria usuarioMateria = modelMapper.map(usuarioMateriaDTO, UsuarioMateria.class);

		UsuarioMateriaId id = new UsuarioMateriaId();
		id.setMateriaId(usuarioMateriaDTO.getMateria().getId());
		id.setUsuarioId(usuarioMateriaDTO.getUsuario().getEmail());

		usuarioMateria.setId(id);

		return usuarioMateria;
	}

	@Override
	@GET
	@Path("/{email}/{materiaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("email") String email, @PathParam("materiaId") Long materiaId) {
		UsuarioMateria usuarioMateria;

		try {
			usuarioMateria = service.find(email, materiaId);

			if (usuarioMateria == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("O usuário não iniciou o estudo da matéria");

				return Response.status(result.getCode()).entity(result).build();
			}

			UsuarioMateriaResultDTO usuarioMateriaDTO = new ModelMapper().map(usuarioMateria,
					UsuarioMateriaResultDTO.class);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("usuarioMateria");
			String responseList = writer.writeValueAsString(usuarioMateriaDTO);

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
	public Response atualizar(UsuarioMateriaSaveWrapper wrapper) {

		UsuarioMateria usuarioMateria = mapDTOToEntity(wrapper.getUsuarioMateriaDTO());

		try {
			service.atualizar(usuarioMateria);

			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Associação entre usuário e matéria atualizada com sucesso");
			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
}
