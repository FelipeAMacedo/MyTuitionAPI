package br.com.felipe.mytuition.app.api.impl;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.felipe.mytuition.app.api.CursoRestful;
import br.com.felipe.mytuition.app.api.dto.curso.CursoDTO;
import br.com.felipe.mytuition.app.api.dto.curso.CursoResultDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.CursoSaveWrapper;
import br.com.felipe.mytuition.app.entity.Curso;
import br.com.felipe.mytuition.app.service.CursoService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/curso")
public class CursoRestfulImpl implements CursoRestful {

	@Autowired
	private CursoService service;

	private Result result = new Result();

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(CursoSaveWrapper wrapper) {

		CursoDTO cursoDTO = wrapper.getCursoDTO();

		ModelMapper mapper = new ModelMapper();
		Curso curso = mapper.map(cursoDTO, Curso.class);

		try {
			service.inserir(curso);
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
	public Response findAll() {
		List<Curso> cursos;

		try {
			cursos = service.buscarTodos();

			if (cursos == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<CursoResultDTO> cursosDTO = mapResultListToDTO(cursos);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("cursos");
			String responseList = writer.writeValueAsString(cursosDTO);

			return Response.ok(responseList).build();
		
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
	
	private List<CursoResultDTO> mapResultListToDTO(List<Curso> cursos) {
		List<CursoResultDTO> cursosDTO = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();
		
		cursos.forEach(curso -> cursosDTO.add(mapper.map(curso, CursoResultDTO.class)));

		return cursosDTO;
	}
	
}
