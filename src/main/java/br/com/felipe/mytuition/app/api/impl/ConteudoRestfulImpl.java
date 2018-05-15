package br.com.felipe.mytuition.app.api.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
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

import br.com.felipe.mytuition.app.api.ConteudoRestful;
import br.com.felipe.mytuition.app.api.dto.conteudo.AlternativasResultDTO;
import br.com.felipe.mytuition.app.api.dto.conteudo.ConteudoResultDTO;
import br.com.felipe.mytuition.app.entity.Conteudo;
import br.com.felipe.mytuition.app.service.ConteudoService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/conteudo")
public class ConteudoRestfulImpl implements ConteudoRestful {

	@Autowired
	private ConteudoService service;

	private Result result = new Result();

	@Override
	@GET
	@Path("/materia/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByMateria(@PathParam("id") Long id) {
		Set<Conteudo> conteudos;

		try {
			conteudos = service.findByMateriaId(id);

			if (conteudos == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<ConteudoResultDTO> conteudosDTO = mapResultListToDTO(conteudos);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("conteudos");
			String responseList = writer.writeValueAsString(conteudosDTO);

			return Response.ok(responseList).build();
		
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private List<ConteudoResultDTO> mapResultListToDTO(Set<Conteudo> conteudos) {
		List<ConteudoResultDTO> conteudosDTO = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		conteudos.forEach(conteudo -> {
			ConteudoResultDTO conteudoDTO = mapper.map(conteudo, ConteudoResultDTO.class); 
			
			Set<AlternativasResultDTO> alternativasDTO = new HashSet<>();
			
			conteudo.getAlternativas().forEach(alternativa -> alternativasDTO.add(mapper.map(alternativa, AlternativasResultDTO.class)));
			
			conteudoDTO.setAlternativas(alternativasDTO);
			conteudosDTO.add(conteudoDTO);
		});

		return conteudosDTO;
	}

	@Override
	@GET
	@Path("/materia/{id}/questoes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findQuestionsByMateria(@PathParam("id") Long id) {
		Set<Conteudo> conteudos;

		try {
			conteudos = service.findQuestionsByMateriaId(id);

			if (conteudos == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<ConteudoResultDTO> conteudosDTO = mapResultListToDTO(conteudos);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("conteudos");
			String responseList = writer.writeValueAsString(conteudosDTO);

			return Response.ok(responseList).build();
		
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
	
	@Override
	@GET
	@Path("/usuario/{id}/questoes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAvailableQuestionsByUsuarioId(@PathParam("id") Long id) {
		Set<Conteudo> conteudos;

		try {
			conteudos = service.findQuestionsByMateriaId(id);

			if (conteudos == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<ConteudoResultDTO> conteudosDTO = mapResultListToDTO(conteudos);

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer().withRootName("conteudos");
			String responseList = writer.writeValueAsString(conteudosDTO);

			return Response.ok(responseList).build();
		
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}
}
