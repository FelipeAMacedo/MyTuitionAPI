package br.com.felipe.mytuition.app.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.felipe.mytuition.app.api.HeroiRestful;
import br.com.felipe.mytuition.app.api.dto.heroi.AtualizacaoExperienciaDTO;
import br.com.felipe.mytuition.app.api.dto.heroi.AumentarPontosDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.AtualizacaoExperienciaWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.AumentarPontosWrapper;
import br.com.felipe.mytuition.app.entity.Heroi;
import br.com.felipe.mytuition.app.service.HeroiService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/heroi")
public class HeroiRestfulImpl implements HeroiRestful {

	@Autowired
	private HeroiService service;

	private Result result = new Result();

	@Override
	@POST
	@Path("/aumentarExperiencia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarExperiencia(AtualizacaoExperienciaWrapper wrapper) {

		AtualizacaoExperienciaDTO dto = wrapper.getAtualizacaoExperienciaDTO();

		try {
			service.adicionarExperiencia(dto.getId(), dto.getPontosAdicionais());
			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Experiência adicionada com sucesso");

			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	@Override
	@POST
	@Path("/aumentarPontos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response aumentarPontos(AumentarPontosWrapper wrapper) {
		AumentarPontosDTO dto = wrapper.getAumentarPontosDTO();
		
		try {
			service.aumentarPontos(convertAumentarPontosDTOToEntity(dto));
			result.setCode(Status.OK.getStatusCode());
			result.setMessage("Pontos aumentados com sucesso");

			return Response.ok(result).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private Heroi convertAumentarPontosDTOToEntity(AumentarPontosDTO dto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(dto, Heroi.class);
	}
}
