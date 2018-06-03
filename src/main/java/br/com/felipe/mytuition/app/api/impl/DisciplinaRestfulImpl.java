package br.com.felipe.mytuition.app.api.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.felipe.mytuition.app.api.DisciplinaRestful;
import br.com.felipe.mytuition.app.api.dto.disciplina.DisciplinaDTO;
import br.com.felipe.mytuition.app.api.dto.disciplina.DisciplinaResultDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.DisciplinaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.usuarioDisciplina.UsuarioDisciplinaResultDTO;
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
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(@HeaderParam(value = "email") String email) {
		List<Disciplina> disciplinas;

		try {
			disciplinas = service.buscarTodas(email);

			if (disciplinas == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<DisciplinaResultDTO> disciplinasDTO = mapResultListToDTO(disciplinas);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("disciplinas");
			String responseList = writer.writeValueAsString(disciplinasDTO);

			return Response.ok(responseList).build();
		
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
	
	private List<DisciplinaResultDTO> mapResultListToDTO(List<Disciplina> disciplinas) {
		List<DisciplinaResultDTO> disciplinasDTO = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		disciplinas.forEach(disciplina -> {
			
			DisciplinaResultDTO disciplinaResult = mapper.map(disciplina, DisciplinaResultDTO.class);
			
			if (!disciplina.getUsuarioDisciplina().isEmpty()) {
				Set<UsuarioDisciplinaResultDTO> usuarioDisciplinaDTO = new HashSet<>(0);
				
				disciplina.getUsuarioDisciplina().forEach(usuarioDisciplina -> usuarioDisciplinaDTO.add(mapper.map(usuarioDisciplina, UsuarioDisciplinaResultDTO.class)));
				disciplinaResult.setUsuarioDisciplinaResultDTO(usuarioDisciplinaDTO);
			}
			
			disciplinasDTO.add(disciplinaResult);
		});

		return disciplinasDTO;
	}
	
}
