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

import br.com.felipe.mytuition.app.api.MateriaRestful;
import br.com.felipe.mytuition.app.api.dto.UsuarioDTO;
import br.com.felipe.mytuition.app.api.dto.materia.MateriaDTO;
import br.com.felipe.mytuition.app.api.dto.materia.MateriaResultDTO;
import br.com.felipe.mytuition.app.api.dto.save.wrapper.MateriaSaveWrapper;
import br.com.felipe.mytuition.app.api.dto.usuarioMateria.UsuarioMateriaResultDTO;
import br.com.felipe.mytuition.app.entity.Conteudo;
import br.com.felipe.mytuition.app.entity.Materia;
import br.com.felipe.mytuition.app.service.MateriaService;
import br.com.felipe.mytuition.app.utils.Result;

@Component
@Path("/materia")
public class MateriaRestfulImpl implements MateriaRestful {

	@Autowired
	private MateriaService service;

	private Result result = new Result();

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(MateriaSaveWrapper wrapper) {

		MateriaDTO materiaDTO = wrapper.getMateriaDTO();

		ModelMapper mapper = new ModelMapper();
		Materia materia = mapper.map(materiaDTO, Materia.class);

		addMateriaToConteudos(materia);

		try {
			service.inserir(materia);
			return Response.ok().build();
		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private void addMateriaToConteudos(Materia materia) {
		materia.getConteudo().forEach(conteudo -> {
			conteudo.setMateria(materia);
			addConteudoToAlternativas(conteudo);
		});

	}

	private void addConteudoToAlternativas(Conteudo conteudo) {
		conteudo.getAlternativas().forEach(alternativa -> {
			alternativa.setConteudo(conteudo);
		});
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		UsuarioDTO usuario = new UsuarioDTO();

		usuario.setEmail("felipe");

		return Response.ok(usuario).build();
	}

	@Override
	@GET
	@Path("/disciplina/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByDisciplina(@HeaderParam(value = "email") String email, @PathParam("id") Long id) {
		List<Materia> materias;

		try {
			materias = service.findByDisciplinaId(email, id);

			if (materias == null) {
				result.setCode(Status.BAD_REQUEST.getStatusCode());
				result.setMessage("A lista está vazia");

				return Response.status(result.getCode()).entity(result).build();
			}

			List<MateriaResultDTO> materiasDTO = mapResultListToDTO(materias);

			String responseList = mapToResponse(materiasDTO);

			return Response.ok(responseList).build();

		} catch (Exception e) {
			result.setCode(Status.BAD_REQUEST.getStatusCode());
			result.setMessage(e.getMessage());

			return Response.status(result.getCode()).entity(result).build();
		}
	}

	private String mapToResponse(List<MateriaResultDTO> materiasDTO) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer().withRootName("materias");

		try {
			return writer.writeValueAsString(materiasDTO);
		} catch (Exception e) {
			throw new Exception("Erro ao converter as matérias em String", e);
		}
	}

	private List<MateriaResultDTO> mapResultListToDTO(List<Materia> materias) {
		List<MateriaResultDTO> materiasDTO = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		materias.forEach(materia -> {

			MateriaResultDTO materiaResult = mapper.map(materia, MateriaResultDTO.class);

			if (!materia.getUsuarioMateria().isEmpty()) {
				Set<UsuarioMateriaResultDTO> usuarioMateriasDTO = new HashSet<>(0);

				materia.getUsuarioMateria().forEach(usuarioMateria -> usuarioMateriasDTO
						.add(mapper.map(usuarioMateria, UsuarioMateriaResultDTO.class)));
				materiaResult.setUsuarioMateriaResultDTO(usuarioMateriasDTO);
			}

			materiasDTO.add(materiaResult);
		});

		return materiasDTO;
	}
}
