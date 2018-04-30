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

import br.com.felipe.mytuition.app.api.DisciplinaRestful;
import br.com.felipe.mytuition.app.api.dto.disciplina.DisciplinaDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.DisciplinaSaveWrapper;
import br.com.felipe.mytuition.app.entity.Disciplina;
import br.com.felipe.mytuition.app.service.DisciplinaService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/disciplina")
public class DisciplinaRestfulImpl implements DisciplinaRestful {

	@Autowired
	private DisciplinaService service;

	private Result result = new Result();

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok().build();
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(DisciplinaSaveWrapper wrapper) {

		DisciplinaDTO disciplinaDTO = wrapper.getDisciplinaDTO();

		ModelMapper mapper = new ModelMapper();
		Disciplina disciplina = mapper.map(disciplinaDTO, Disciplina.class);

		try {
			service.inserir(disciplina);
			return Response.ok().build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
	
}
