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

import br.com.felipe.mytuition.app.api.ConquistaRestful;
import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaBuscaDTO;
import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaResultDTO;
import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaSaveDTO;
import br.com.felipe.mytuition.app.api.dto.conquista.ConquistaUsuarioDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaBuscaWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.ConquistaUsuarioSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.usuarioConquista.UsuarioConquistaResultDTO;
import br.com.felipe.mytuition.app.entity.Conquista;
import br.com.felipe.mytuition.app.entity.Disciplina;
import br.com.felipe.mytuition.app.entity.UsuarioConquista;
import br.com.felipe.mytuition.app.service.ConquistaService;
import br.com.felipe.mytuition.app.service.UsuarioConquistaService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/conquista")
public class ConquistaRestfulImpl implements ConquistaRestful {

	@Autowired
	private ConquistaService conquistaService;

	@Autowired
	private UsuarioConquistaService usuarioConquistaService;

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
	public Response insert(ConquistaSaveWrapper wrapper) {

		ConquistaSaveDTO conquistaDTO = wrapper.getConquistaDTO();

		Conquista conquista = mapConquistaSaveToEntity(conquistaDTO);

		try {
			conquistaService.insert(conquista);
			return Response.ok().build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private Conquista mapConquistaSaveToEntity(ConquistaSaveDTO conquistaDTO) {
		ModelMapper mapper = new ModelMapper();
		Conquista conquista = mapper.map(conquistaDTO, Conquista.class);

		if (conquistaDTO.getDisciplinaConquistaSaveDTO() != null
				&& conquistaDTO.getDisciplinaConquistaSaveDTO().getId() != 0) {

			Disciplina disciplina = new Disciplina();
			disciplina.setId(conquistaDTO.getDisciplinaConquistaSaveDTO().getId());
			conquista.setDisciplina(disciplina);
		}

		return conquista;
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/usuario")
	public Response conquistar(ConquistaUsuarioSaveWrapper wrapper) {
		ConquistaUsuarioDTO conquistaUsuarioDTO = wrapper.getConquistaUsuarioDTO();

		ModelMapper mapper = new ModelMapper();
		UsuarioConquista usuarioConquista = mapper.map(conquistaUsuarioDTO, UsuarioConquista.class);

		try {
			usuarioConquistaService.inserir(usuarioConquista);
			return Response.ok().build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	@Override
	@POST
	@Path("/buscarNovasAtualizacoes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarNovasAtualizacoes(ConquistaBuscaWrapper wrapper, @HeaderParam("email") String email) {

		List<ConquistaBuscaDTO> conquistasDTO = wrapper.getConquistaBuscaDTO();
		List<Conquista> conquistas = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();
		conquistasDTO.forEach(conquistaDTO -> conquistas.add(mapper.map(conquistaDTO, Conquista.class)));

		try {
			List<ConquistaResultDTO> novasConquistasDTO = mapResultListToDTO(
					conquistaService.buscarNovasAtualizacoes(conquistas, email));

			String responseList = mapToResponse(novasConquistasDTO);

			return Response.ok(responseList).build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private String mapToResponse(List<ConquistaResultDTO> novasConquistasDTO) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer().withRootName("conquistas");

		try {
			return writer.writeValueAsString(novasConquistasDTO);
		} catch (Exception e) {
			throw new Exception("Erro ao converter as conquistas atualizadas em String", e);
		}
	}

	private List<ConquistaResultDTO> mapResultListToDTO(List<Conquista> conquistas) {
		List<ConquistaResultDTO> conquistaResultDTO = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		conquistas.forEach(conquista -> {
			
			ConquistaResultDTO conquistaResult = mapper.map(conquista, ConquistaResultDTO.class);
			
			if (!conquista.getUsuarioConquista().isEmpty()) {
				Set<UsuarioConquistaResultDTO> usuarioConquistasDTO = new HashSet<>(0);
				
				conquista.getUsuarioConquista().forEach(usuarioConquista -> usuarioConquistasDTO.add(mapper.map(usuarioConquista, UsuarioConquistaResultDTO.class)));
				conquistaResult.setUsuarioConquistaResultDTO(usuarioConquistasDTO);
			}
			
			conquistaResultDTO.add(conquistaResult);
		});

		return conquistaResultDTO;
	}

}
